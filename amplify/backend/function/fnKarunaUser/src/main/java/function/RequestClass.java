

package function;
        
public class RequestClass {
    String awsUserId;
    String surname;
    String firstName;
    String emailAddress;
    String accountType;
    String accountStatus;

     public RequestClass(String awsUserId, String surname, String firstName, String emailAddress, String accountType, String accountStatus) {
         this.awsUserId = awsUserId;
         this.surname = surname;
         this.firstName = firstName;
         this.emailAddress = emailAddress;
         this.accountType = accountType;
         this.accountStatus = accountStatus;
     }

    public RequestClass() {
    }

    public String getAwsUserId() {
        return awsUserId;
    }

    public void setAwsUserId(String awsUserId) {
        this.awsUserId = awsUserId;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}