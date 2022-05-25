

package function;
        
     public class RequestClass {

         String surname;
         String firstName;
         String location;
         String vitalStats;
         String uploadedByUser;
         String faceId;
         String imageId;
         String imageFileName;
         String imageFile;

         public RequestClass() {
         }

         public RequestClass(String surname, String firstName, String location, String vitalStats, String uploadedByUser, String faceId, String imageId, String imageFileName, String imageFile) {
             this.surname = surname;
             this.firstName = firstName;
             this.location = location;
             this.vitalStats = vitalStats;
             this.uploadedByUser = uploadedByUser;
             this.faceId = faceId;
             this.imageId = imageId;
             this.imageFileName = imageFileName;
             this.imageFile = imageFile;
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

         public String getFaceId() {
             return faceId;
         }

         public void setFaceId(String faceId) {
             this.faceId = faceId;
         }

         public String getImageId() {
             return imageId;
         }

         public void setImageId(String imageId) {
             this.imageId = imageId;
         }

         public String getImageFile() {
             return imageFile;
         }

         public void setImageFile(String image) {
             this.imageFile = image;
         }

         public String getImageFileName() {
             return imageFileName;
         }

         public void setImageFileName(String imageFileName) {
             this.imageFileName = imageFileName;
         }


     }