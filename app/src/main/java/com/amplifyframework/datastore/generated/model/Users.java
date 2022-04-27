package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasMany;

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
  public static final QueryField EMAIL_ADDRESS = field("Users", "emailAddress");
  public static final QueryField DATE_CREATED = field("Users", "dateCreated");
  public static final QueryField ACCOUNT_TYPE = field("Users", "accountType");
  public static final QueryField ACCOUNT_STATUS = field("Users", "accountStatus");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSEmail") String emailAddress;
  private final @ModelField(targetType="AWSDate") Temporal.Date dateCreated;
  private final @ModelField(targetType="String") String accountType;
  private final @ModelField(targetType="Boolean") Boolean accountStatus;
  private final @ModelField(targetType="LocatedPersons") @HasMany(associatedWith = "usersID", type = LocatedPersons.class) List<LocatedPersons> LocatedPersons = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getEmailAddress() {
      return emailAddress;
  }
  
  public Temporal.Date getDateCreated() {
      return dateCreated;
  }
  
  public String getAccountType() {
      return accountType;
  }
  
  public Boolean getAccountStatus() {
      return accountStatus;
  }
  
  public List<LocatedPersons> getLocatedPersons() {
      return LocatedPersons;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Users(String id, String emailAddress, Temporal.Date dateCreated, String accountType, Boolean accountStatus) {
    this.id = id;
    this.emailAddress = emailAddress;
    this.dateCreated = dateCreated;
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
              ObjectsCompat.equals(getEmailAddress(), users.getEmailAddress()) &&
              ObjectsCompat.equals(getDateCreated(), users.getDateCreated()) &&
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
      .append(getEmailAddress())
      .append(getDateCreated())
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
      .append("emailAddress=" + String.valueOf(getEmailAddress()) + ", ")
      .append("dateCreated=" + String.valueOf(getDateCreated()) + ", ")
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      emailAddress,
      dateCreated,
      accountType,
      accountStatus);
  }
  public interface BuildStep {
    Users build();
    BuildStep id(String id);
    BuildStep emailAddress(String emailAddress);
    BuildStep dateCreated(Temporal.Date dateCreated);
    BuildStep accountType(String accountType);
    BuildStep accountStatus(Boolean accountStatus);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String emailAddress;
    private Temporal.Date dateCreated;
    private String accountType;
    private Boolean accountStatus;
    @Override
     public Users build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Users(
          id,
          emailAddress,
          dateCreated,
          accountType,
          accountStatus);
    }
    
    @Override
     public BuildStep emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
    
    @Override
     public BuildStep dateCreated(Temporal.Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
    
    @Override
     public BuildStep accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }
    
    @Override
     public BuildStep accountStatus(Boolean accountStatus) {
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
    private CopyOfBuilder(String id, String emailAddress, Temporal.Date dateCreated, String accountType, Boolean accountStatus) {
      super.id(id);
      super.emailAddress(emailAddress)
        .dateCreated(dateCreated)
        .accountType(accountType)
        .accountStatus(accountStatus);
    }
    
    @Override
     public CopyOfBuilder emailAddress(String emailAddress) {
      return (CopyOfBuilder) super.emailAddress(emailAddress);
    }
    
    @Override
     public CopyOfBuilder dateCreated(Temporal.Date dateCreated) {
      return (CopyOfBuilder) super.dateCreated(dateCreated);
    }
    
    @Override
     public CopyOfBuilder accountType(String accountType) {
      return (CopyOfBuilder) super.accountType(accountType);
    }
    
    @Override
     public CopyOfBuilder accountStatus(Boolean accountStatus) {
      return (CopyOfBuilder) super.accountStatus(accountStatus);
    }
  }
  
}
