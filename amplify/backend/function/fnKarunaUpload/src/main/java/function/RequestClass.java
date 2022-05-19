

package function;
        
     public class RequestClass {

         String surname;
         String firstName;
         String location;
         String vitalStats;
         String uploadedByUser;
         String awsFaceId;
         String awsS3URL;

         public RequestClass() {
         }

         public RequestClass(String surname, String firstName, String location, String vitalStats, String uploadedByUser, String awsFaceId, String awsS3URL) {
             this.surname = surname;
             this.firstName = firstName;
             this.location = location;
             this.vitalStats = vitalStats;
             this.uploadedByUser = uploadedByUser;
             this.awsFaceId = awsFaceId;
             this.awsS3URL = awsS3URL;
         }

         public String getSurname() {
             return surname;
         }

         public void setSurname(String surname) {
             this.surname = surname;
         }

         public String getFirstName() {
             return firstName;
         }

         public void setFirstName(String firstName) {
             this.firstName = firstName;
         }

         public String getLocation() {
             return location;
         }

         public void setLocation(String location) {
             this.location = location;
         }

         public String getVitalStats() {
             return vitalStats;
         }

         public void setVitalStats(String vitalStats) {
             this.vitalStats = vitalStats;
         }

         public String getUploadedByUser() {
             return uploadedByUser;
         }

         public void setUploadedByUser(String uploadedByUser) {
             this.uploadedByUser = uploadedByUser;
         }

         public String getAwsFaceId() {
             return awsFaceId;
         }

         public void setAwsFaceId(String awsFaceId) {
             this.awsFaceId = awsFaceId;
         }

         public String getAwsS3URL() {
             return awsS3URL;
         }

         public void setAwsS3URL(String awsS3URL) {
             this.awsS3URL = awsS3URL;
         }
     }