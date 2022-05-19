

package function;

import com.amazonaws.services.lambda.runtime.Context; 
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.*;

public class LambdaRequestHandler implements RequestHandler<RequestClass, ResponseClass>{

    public ResponseClass handleRequest(RequestClass request, Context context){
        //String greetingString = String.format("Hello %s %s!", request.firstName, request.lastName);
        String greetingString = "";

        String url = "jdbc:mysql://karunadb.ctmmdehvnw1j.ap-southeast-2.rds.amazonaws.com:3306/karunadb";
        String user = "karuna_admin";
        String passwd = "T0pG3ar123";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Loaded driver");

            System.out.println("Trying Connection");
            try (Connection conn = DriverManager.getConnection(url, user, passwd);){
                System.out.println("Connected");

                String query = "{CALL sp_addUser(?,?,?,?,?,?)}";

                CallableStatement stmt = conn.prepareCall(query);
                stmt.setString("_awsUserId", request.awsUserId);
                stmt.setString("_surname",request.surname);
                stmt.setString("_firstName", request.firstName);
                stmt.setString("_emailAddress", request.emailAddress);
                stmt.setString("_accountType",request.accountType);
                stmt.setString("_accountStatus", request.accountStatus);

                greetingString = stmt.toString();
                stmt.execute();


            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ResponseClass(greetingString);
    }
}