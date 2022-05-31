

package function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import function.model.LocatedPerson;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.*;
import software.amazon.awssdk.services.rekognition.model.Attribute;
import software.amazon.awssdk.services.rekognition.model.CreateCollectionRequest;
import software.amazon.awssdk.services.rekognition.model.CreateCollectionResponse;
import software.amazon.awssdk.services.rekognition.model.DetectFacesRequest;
import software.amazon.awssdk.services.rekognition.model.DetectFacesResponse;
import software.amazon.awssdk.services.rekognition.model.FaceDetail;
import software.amazon.awssdk.services.rekognition.model.FaceRecord;
import software.amazon.awssdk.services.rekognition.model.Image;
import software.amazon.awssdk.services.rekognition.model.IndexFacesRequest;
import software.amazon.awssdk.services.rekognition.model.IndexFacesResponse;
import software.amazon.awssdk.services.rekognition.model.ListCollectionsRequest;
import software.amazon.awssdk.services.rekognition.model.ListCollectionsResponse;
import software.amazon.awssdk.services.rekognition.model.QualityFilter;
import software.amazon.awssdk.services.rekognition.model.Reason;
import software.amazon.awssdk.services.rekognition.model.RekognitionException;
import software.amazon.awssdk.services.rekognition.model.UnindexedFace;

import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.*;


import java.nio.ByteBuffer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;


//public class LambdaRequestHandler implements RequestHandler<RequestClass, ResponseClass>{
public class LambdaRequestHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{

    static String url = "jdbc:mysql://karunadb.ctmmdehvnw1j.ap-southeast-2.rds.amazonaws.com:3306/karunadb";
    static String user = "karuna_admin";
    static String passwd = "T0pG3ar123";
    static String accessKey = "AKIAZPAU4HZFZ5Y6ACGF";
    static String secretKey = "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";
    static String s3BucketName = "karuna-images";

    //public ResponseClass handleRequest(RequestClass request, Context context){
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context){
        //String greetingString = String.format("Hello %s %s!", request.firstName, request.lastName);
        String greetingString = "";
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

        try {
            System.out.println(request.getBody());

            System.out.println("converting to gson...");
            LocatedPerson locatedPerson = new Gson().fromJson(request.getBody(), LocatedPerson.class);

            String locationName = getActiveDisaster();

            if (!checkDisasterExists(locationName))
                createRekognitionCollection(locationName);

            //String imageType = FilenameUtils.getExtension(locatedPerson.getImageFileName());

            if(detectFacesinImage(locatedPerson.getImageFile()) > 1) {
                throw new Exception("Too many faces in uploaded image.  Use image with 1 face.");
            }
            addToCollection(locatedPerson, locationName, locatedPerson.getImageFile());
            saveToS3(s3BucketName, locatedPerson.getImageId(), locatedPerson.getImageFileType(), locatedPerson.getImageFile());
            createDatabaseRecord(locatedPerson);

            return responseEvent
                    .withBody("Successfully added located person")
                    .withStatusCode(200);
        }
        catch (Exception e) {

            return responseEvent
                    .withBody(e.getMessage())
                    .withStatusCode(500);
        }
    }


    public void createDatabaseRecord(LocatedPerson locatedPerson) {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Loaded driver");

            System.out.println("Trying Connection");

            System.out.println(locatedPerson.getFaceId());
            System.out.println(locatedPerson.getImageId());

            System.out.println("Trying Connection");
            try (Connection conn = DriverManager.getConnection(url, user, passwd)) {
                System.out.println("Connected...");

                String query = "{CALL sp_addLocatedPerson(?,?,?,?,?,?,?,?)}";

                CallableStatement stmt = conn.prepareCall(query);
                stmt.setString("_surname", locatedPerson.getSurname());
                stmt.setString("_firstName", locatedPerson.getFirstName());
                stmt.setString("_location", locatedPerson.getLocation());
                stmt.setString("_vitalStats", locatedPerson.getVitalStats());
                stmt.setString("_uploadedByUser", locatedPerson.getUploadedByUser());
                stmt.setString("_faceId", locatedPerson.getFaceId());
                stmt.setString("_imageId", locatedPerson.getImageId());
                stmt.setString("_imageFileType", locatedPerson.getImageFileType());

                stmt.execute();

                System.out.println(stmt.toString());

            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }

        }
        catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


    public void createRekognitionCollection(String locationName)
    {
        System.out.println("Executing createRekognitionCollection");

        Region region = Region.AP_SOUTHEAST_2;
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);

        RekognitionClient rekClient = RekognitionClient.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        System.out.println("created rekclient");


        System.out.println("Creating collection: " +
                locationName);

        try {
            CreateCollectionRequest collectionRequest = CreateCollectionRequest.builder()
                    .collectionId(locationName)
                    .build();

            System.out.println("created collection ok");

            CreateCollectionResponse collectionResponse = rekClient.createCollection(collectionRequest);
            System.out.println("CollectionArn : " +
                    collectionResponse.collectionArn());
            System.out.println("Status code : " +
                    collectionResponse.statusCode().toString());

        } catch(RekognitionException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        rekClient.close();
    }


    public void saveToS3(String bucketName, String fileName, String imageType, String imageFile)
    {
        System.out.println("Executing saveToS3");
        Region region = Region.AP_SOUTHEAST_2;
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);

        S3Client s3Client = S3Client.builder()
                .region(region)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        System.out.println("S3client created");

        String keyName = fileName + "." + imageType;

        System.out.println(keyName);

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(keyName)
                .build();

        ByteBuffer data = ByteBuffer.wrap(Base64.getDecoder().decode(imageFile));

        s3Client.putObject(objectRequest, RequestBody.fromByteBuffer(data));
        System.out.println("Put object completed");


    }


    public void addToCollection(LocatedPerson locatedPerson, String collectionId, String sourceImage) {

        //String imageId = "";

        try {

            System.out.println("Executing addToCollection");
            System.out.println("Executing createRekognitionClient");

            Region region = Region.AP_SOUTHEAST_2;
            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);

            RekognitionClient rekClient = RekognitionClient.builder()
                    .region(region)
                    .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                    .build();


            //InputStream sourceStream = new FileInputStream(sourceImage);
            //SdkBytes sourceBytes = SdkBytes.fromInputStream(sourceStream);

            Image souImage = Image.builder()
                    .bytes(SdkBytes.fromByteBuffer(ByteBuffer.wrap(Base64.getDecoder().decode(sourceImage))))
                    .build();

            IndexFacesRequest facesRequest = IndexFacesRequest.builder()
                    .collectionId(collectionId)
                    .image(souImage)
                    .maxFaces(1)
                    .qualityFilter(QualityFilter.AUTO)
                    .detectionAttributes(Attribute.DEFAULT)
                    .build();

            IndexFacesResponse facesResponse = rekClient.indexFaces(facesRequest);


            // Display the results.
            System.out.println("Results for the image");
            System.out.println("\n Faces indexed:");
            List<FaceRecord> faceRecords = facesResponse.faceRecords();
            for (FaceRecord faceRecord : faceRecords) {
                System.out.println("  Face ID: " + faceRecord.face().faceId());
                System.out.println("  Location:" + faceRecord.faceDetail().boundingBox().toString());
                System.out.println("  Image ID: " + faceRecord.face().imageId());
                //imageId = faceRecord.face().imageId();

                locatedPerson.setFaceId(faceRecord.face().faceId());
                locatedPerson.setImageId(faceRecord.face().imageId());
            }

            List<UnindexedFace> unindexedFaces = facesResponse.unindexedFaces();
            System.out.println("Faces not indexed:");
            for (UnindexedFace unindexedFace : unindexedFaces) {
                System.out.println("  Location:" + unindexedFace.faceDetail().boundingBox().toString());
                System.out.println("  Reasons:");
                for (Reason reason : unindexedFace.reasons()) {
                    System.out.println("Reason:  " + reason);
                }
            }

        } catch (RekognitionException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }


    public String getActiveDisaster() {

        System.out.println("Executing getActiveDisaster");
        String locationName = "";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Loaded driver");

            System.out.println("Trying Connection");
            try (Connection conn = DriverManager.getConnection(url, user, passwd);){
                System.out.println("Connected");

                String query = "{CALL sp_getActiveDisaster}";
                CallableStatement stmt = conn.prepareCall(query);

                System.out.println("Statement executing");
                ResultSet results = stmt.executeQuery();

                System.out.println(results.toString());
                results.next();

                locationName = results.getString("locationName");
                System.out.println(locationName);

            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return locationName;
    }


    public static boolean checkDisasterExists(String locationName) {

        try {

            Region region = Region.AP_SOUTHEAST_2;
            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);

            RekognitionClient rekClient = RekognitionClient.builder()
                    .region(region)
                    .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                    .build();

            ListCollectionsRequest listCollectionsRequest = ListCollectionsRequest.builder()
                    .maxResults(10)
                    .build();

            ListCollectionsResponse response = rekClient.listCollections(listCollectionsRequest);
            List<String> collectionIds = response.collectionIds();
            for (String resultId : collectionIds) {
                System.out.println(resultId);

                if (resultId.equals(locationName))
                    return true;
            }

        } catch (RekognitionException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return false;
    }

    public static int detectFacesinImage(String sourceImage) {

        try {

            System.out.println("Executing addToCollection");
            System.out.println("Executing createRekognitionClient");

            Region region = Region.AP_SOUTHEAST_2;
            AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);

            RekognitionClient rekClient = RekognitionClient.builder()
                    .region(region)
                    .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                    .build();

            Image souImage = Image.builder()
                    .bytes(SdkBytes.fromByteBuffer(ByteBuffer.wrap(Base64.getDecoder().decode(sourceImage))))
                    .build();

            DetectFacesRequest facesRequest = DetectFacesRequest.builder()
                    .attributes(Attribute.ALL)
                    .image(souImage)
                    .build();

            DetectFacesResponse facesResponse = rekClient.detectFaces(facesRequest);
            List<FaceDetail> faceDetails = facesResponse.faceDetails();

            return faceDetails.size();

        } catch (RekognitionException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return 0;
    }
}