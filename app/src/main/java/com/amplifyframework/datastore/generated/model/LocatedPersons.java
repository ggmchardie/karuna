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

/** This is an auto generated class representing the LocatedPersons type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "LocatedPersons", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class LocatedPersons implements Model {
  public static final QueryField ID = field("LocatedPersons", "id");
  public static final QueryField SURNAME = field("LocatedPersons", "surname");
  public static final QueryField FIRST_NAME = field("LocatedPersons", "firstName");
  public static final QueryField DATE_ENTERED = field("LocatedPersons", "dateEntered");
  public static final QueryField LOCATION = field("LocatedPersons", "location");
  public static final QueryField STATUS = field("LocatedPersons", "status");
  public static final QueryField HAS_PHOTO = field("LocatedPersons", "hasPhoto");
  public static final QueryField UPLOADED_BY_USER = field("LocatedPersons", "uploadedByUser");
  public static final QueryField DISASTER_ID = field("LocatedPersons", "disasterId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String surname;
  private final @ModelField(targetType="String") String firstName;
  private final @ModelField(targetType="AWSDate") Temporal.Date dateEntered;
  private final @ModelField(targetType="String") String location;
  private final @ModelField(targetType="String") String status;
  private final @ModelField(targetType="Boolean") Boolean hasPhoto;
  private final @ModelField(targetType="String") String uploadedByUser;
  private final @ModelField(targetType="String") String disasterId;
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
  
  public Temporal.Date getDateEntered() {
      return dateEntered;
  }
  
  public String getLocation() {
      return location;
  }
  
  public String getStatus() {
      return status;
  }
  
  public Boolean getHasPhoto() {
      return hasPhoto;
  }
  
  public String getUploadedByUser() {
      return uploadedByUser;
  }
  
  public String getDisasterId() {
      return disasterId;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private LocatedPersons(String id, String surname, String firstName, Temporal.Date dateEntered, String location, String status, Boolean hasPhoto, String uploadedByUser, String disasterId) {
    this.id = id;
    this.surname = surname;
    this.firstName = firstName;
    this.dateEntered = dateEntered;
    this.location = location;
    this.status = status;
    this.hasPhoto = hasPhoto;
    this.uploadedByUser = uploadedByUser;
    this.disasterId = disasterId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      LocatedPersons locatedPersons = (LocatedPersons) obj;
      return ObjectsCompat.equals(getId(), locatedPersons.getId()) &&
              ObjectsCompat.equals(getSurname(), locatedPersons.getSurname()) &&
              ObjectsCompat.equals(getFirstName(), locatedPersons.getFirstName()) &&
              ObjectsCompat.equals(getDateEntered(), locatedPersons.getDateEntered()) &&
              ObjectsCompat.equals(getLocation(), locatedPersons.getLocation()) &&
              ObjectsCompat.equals(getStatus(), locatedPersons.getStatus()) &&
              ObjectsCompat.equals(getHasPhoto(), locatedPersons.getHasPhoto()) &&
              ObjectsCompat.equals(getUploadedByUser(), locatedPersons.getUploadedByUser()) &&
              ObjectsCompat.equals(getDisasterId(), locatedPersons.getDisasterId()) &&
              ObjectsCompat.equals(getCreatedAt(), locatedPersons.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), locatedPersons.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getSurname())
      .append(getFirstName())
      .append(getDateEntered())
      .append(getLocation())
      .append(getStatus())
      .append(getHasPhoto())
      .append(getUploadedByUser())
      .append(getDisasterId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("LocatedPersons {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("surname=" + String.valueOf(getSurname()) + ", ")
      .append("firstName=" + String.valueOf(getFirstName()) + ", ")
      .append("dateEntered=" + String.valueOf(getDateEntered()) + ", ")
      .append("location=" + String.valueOf(getLocation()) + ", ")
      .append("status=" + String.valueOf(getStatus()) + ", ")
      .append("hasPhoto=" + String.valueOf(getHasPhoto()) + ", ")
      .append("uploadedByUser=" + String.valueOf(getUploadedByUser()) + ", ")
      .append("disasterId=" + String.valueOf(getDisasterId()) + ", ")
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
  public static LocatedPersons justId(String id) {
    return new LocatedPersons(
      id,
      null,
      null,
      null,
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
      dateEntered,
      location,
      status,
      hasPhoto,
      uploadedByUser,
      disasterId);
  }
  public interface BuildStep {
    LocatedPersons build();
    BuildStep id(String id);
    BuildStep surname(String surname);
    BuildStep firstName(String firstName);
    BuildStep dateEntered(Temporal.Date dateEntered);
    BuildStep location(String location);
    BuildStep status(String status);
    BuildStep hasPhoto(Boolean hasPhoto);
    BuildStep uploadedByUser(String uploadedByUser);
    BuildStep disasterId(String disasterId);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String surname;
    private String firstName;
    private Temporal.Date dateEntered;
    private String location;
    private String status;
    private Boolean hasPhoto;
    private String uploadedByUser;
    private String disasterId;
    @Override
     public LocatedPersons build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new LocatedPersons(
          id,
          surname,
          firstName,
          dateEntered,
          location,
          status,
          hasPhoto,
          uploadedByUser,
          disasterId);
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
     public BuildStep dateEntered(Temporal.Date dateEntered) {
        this.dateEntered = dateEntered;
        return this;
    }
    
    @Override
     public BuildStep location(String location) {
        this.location = location;
        return this;
    }
    
    @Override
     public BuildStep status(String status) {
        this.status = status;
        return this;
    }
    
    @Override
     public BuildStep hasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
        return this;
    }
    
    @Override
     public BuildStep uploadedByUser(String uploadedByUser) {
        this.uploadedByUser = uploadedByUser;
        return this;
    }
    
    @Override
     public BuildStep disasterId(String disasterId) {
        this.disasterId = disasterId;
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
    private CopyOfBuilder(String id, String surname, String firstName, Temporal.Date dateEntered, String location, String status, Boolean hasPhoto, String uploadedByUser, String disasterId) {
      super.id(id);
      super.surname(surname)
        .firstName(firstName)
        .dateEntered(dateEntered)
        .location(location)
        .status(status)
        .hasPhoto(hasPhoto)
        .uploadedByUser(uploadedByUser)
        .disasterId(disasterId);
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
     public CopyOfBuilder dateEntered(Temporal.Date dateEntered) {
      return (CopyOfBuilder) super.dateEntered(dateEntered);
    }
    
    @Override
     public CopyOfBuilder location(String location) {
      return (CopyOfBuilder) super.location(location);
    }
    
    @Override
     public CopyOfBuilder status(String status) {
      return (CopyOfBuilder) super.status(status);
    }
    
    @Override
     public CopyOfBuilder hasPhoto(Boolean hasPhoto) {
      return (CopyOfBuilder) super.hasPhoto(hasPhoto);
    }
    
    @Override
     public CopyOfBuilder uploadedByUser(String uploadedByUser) {
      return (CopyOfBuilder) super.uploadedByUser(uploadedByUser);
    }
    
    @Override
     public CopyOfBuilder disasterId(String disasterId) {
      return (CopyOfBuilder) super.disasterId(disasterId);
    }
  }
  
}
