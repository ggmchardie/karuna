package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Users type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Users", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Users implements Model {
  public static final QueryField ID = field("Users", "id");
  public static final QueryField SURNAME = field("Users", "surname");
  public static final QueryField FIRST_NAME = field("Users", "firstName");
  public static final QueryField EMAIL_ADDRESS = field("Users", "emailAddress");
  public static final QueryField ACCOUNT_TYPE = field("Users", "accountType");
  public static final QueryField ACCOUNT_STATUS = field("Users", "accountStatus");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String surname;
  private final @ModelField(targetType="String") String firstName;
  private final @ModelField(targetType="String") String emailAddress;
  private final @ModelField(targetType="String") String accountType;
  private final @ModelField(targetType="String") String accountStatus;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getSurname() {
      return surname;
  }
  
  public String getFirstName() {
      return firstName;
  }
  
  public String getEmailAddress() {
      return emailAddress;
  }
  
  public String getAccountType() {
      return accountType;
  }
  
  public String getAccountStatus() {
      return accountStatus;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Users(String id, String surname, String firstName, String emailAddress, String accountType, String accountStatus) {
    this.id = id;
    this.surname = surname;
    this.firstName = firstName;
    this.emailAddress = emailAddress;
    this.accountType = accountType;
    this.accountStatus = accountStatus;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Users users = (Users) obj;
      return ObjectsCompat.equals(getId(), users.getId()) &&
              ObjectsCompat.equals(getSurname(), users.getSurname()) &&
              ObjectsCompat.equals(getFirstName(), users.getFirstName()) &&
              ObjectsCompat.equals(getEmailAddress(), users.getEmailAddress()) &&
              ObjectsCompat.equals(getAccountType(), users.getAccountType()) &&
              ObjectsCompat.equals(getAccountStatus(), users.getAccountStatus()) &&
              ObjectsCompat.equals(getCreatedAt(), users.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), users.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getSurname())
      .append(getFirstName())
      .append(getEmailAddress())
      .append(getAccountType())
      .append(getAccountStatus())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Users {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("surname=" + String.valueOf(getSurname()) + ", ")
      .append("firstName=" + String.valueOf(getFirstName()) + ", ")
      .append("emailAddress=" + String.valueOf(getEmailAddress()) + ", ")
      .append("accountType=" + String.valueOf(getAccountType()) + ", ")
      .append("accountStatus=" + String.valueOf(getAccountStatus()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Users justId(String id) {
    return new Users(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      surname,
      firstName,
      emailAddress,
      accountType,
      accountStatus);
  }
  public interface BuildStep {
    Users build();
    BuildStep id(String id);
    BuildStep surname(String surname);
    BuildStep firstName(String firstName);
    BuildStep emailAddress(String emailAddress);
    BuildStep accountType(String accountType);
    BuildStep accountStatus(String accountStatus);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String surname;
    private String firstName;
    private String emailAddress;
    private String accountType;
    private String accountStatus;
    @Override
     public Users build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Users(
          id,
          surname,
          firstName,
          emailAddress,
          accountType,
          accountStatus);
    }
    
    @Override
     public BuildStep surname(String surname) {
        this.surname = surname;
        return this;
    }
    
    @Override
     public BuildStep firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    @Override
     public BuildStep emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
    
    @Override
     public BuildStep accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }
    
    @Override
     public BuildStep accountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String surname, String firstName, String emailAddress, String accountType, String accountStatus) {
      super.id(id);
      super.surname(surname)
        .firstName(firstName)
        .emailAddress(emailAddress)
        .accountType(accountType)
        .accountStatus(accountStatus);
    }
    
    @Override
     public CopyOfBuilder surname(String surname) {
      return (CopyOfBuilder) super.surname(surname);
    }
    
    @Override
     public CopyOfBuilder firstName(String firstName) {
      return (CopyOfBuilder) super.firstName(firstName);
    }
    
    @Override
     public CopyOfBuilder emailAddress(String emailAddress) {
      return (CopyOfBuilder) super.emailAddress(emailAddress);
    }
    
    @Override
     public CopyOfBuilder accountType(String accountType) {
      return (CopyOfBuilder) super.accountType(accountType);
    }
    
    @Override
     public CopyOfBuilder accountStatus(String accountStatus) {
      return (CopyOfBuilder) super.accountStatus(accountStatus);
    }
  }
  
}
