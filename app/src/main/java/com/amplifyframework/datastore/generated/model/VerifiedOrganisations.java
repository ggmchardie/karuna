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

/** This is an auto generated class representing the VerifiedOrganisations type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "VerifiedOrganisations", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class VerifiedOrganisations implements Model {
  public static final QueryField ID = field("VerifiedOrganisations", "id");
  public static final QueryField ORGANISATION_NAME = field("VerifiedOrganisations", "organisationName");
  public static final QueryField DOMAIN_NAME = field("VerifiedOrganisations", "domainName");
  public static final QueryField MAIN_CONTACT_NAME = field("VerifiedOrganisations", "mainContactName");
  public static final QueryField MAIN_CONTACT_EMAIL = field("VerifiedOrganisations", "mainContactEmail");
  public static final QueryField MAIN_CONTACT_PHONE = field("VerifiedOrganisations", "mainContactPhone");
  public static final QueryField ADDRESS = field("VerifiedOrganisations", "address");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String organisationName;
  private final @ModelField(targetType="String") String domainName;
  private final @ModelField(targetType="String") String mainContactName;
  private final @ModelField(targetType="String") String mainContactEmail;
  private final @ModelField(targetType="String") String mainContactPhone;
  private final @ModelField(targetType="String") String address;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getOrganisationName() {
      return organisationName;
  }
  
  public String getDomainName() {
      return domainName;
  }
  
  public String getMainContactName() {
      return mainContactName;
  }
  
  public String getMainContactEmail() {
      return mainContactEmail;
  }
  
  public String getMainContactPhone() {
      return mainContactPhone;
  }
  
  public String getAddress() {
      return address;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private VerifiedOrganisations(String id, String organisationName, String domainName, String mainContactName, String mainContactEmail, String mainContactPhone, String address) {
    this.id = id;
    this.organisationName = organisationName;
    this.domainName = domainName;
    this.mainContactName = mainContactName;
    this.mainContactEmail = mainContactEmail;
    this.mainContactPhone = mainContactPhone;
    this.address = address;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      VerifiedOrganisations verifiedOrganisations = (VerifiedOrganisations) obj;
      return ObjectsCompat.equals(getId(), verifiedOrganisations.getId()) &&
              ObjectsCompat.equals(getOrganisationName(), verifiedOrganisations.getOrganisationName()) &&
              ObjectsCompat.equals(getDomainName(), verifiedOrganisations.getDomainName()) &&
              ObjectsCompat.equals(getMainContactName(), verifiedOrganisations.getMainContactName()) &&
              ObjectsCompat.equals(getMainContactEmail(), verifiedOrganisations.getMainContactEmail()) &&
              ObjectsCompat.equals(getMainContactPhone(), verifiedOrganisations.getMainContactPhone()) &&
              ObjectsCompat.equals(getAddress(), verifiedOrganisations.getAddress()) &&
              ObjectsCompat.equals(getCreatedAt(), verifiedOrganisations.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), verifiedOrganisations.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getOrganisationName())
      .append(getDomainName())
      .append(getMainContactName())
      .append(getMainContactEmail())
      .append(getMainContactPhone())
      .append(getAddress())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("VerifiedOrganisations {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("organisationName=" + String.valueOf(getOrganisationName()) + ", ")
      .append("domainName=" + String.valueOf(getDomainName()) + ", ")
      .append("mainContactName=" + String.valueOf(getMainContactName()) + ", ")
      .append("mainContactEmail=" + String.valueOf(getMainContactEmail()) + ", ")
      .append("mainContactPhone=" + String.valueOf(getMainContactPhone()) + ", ")
      .append("address=" + String.valueOf(getAddress()) + ", ")
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
  public static VerifiedOrganisations justId(String id) {
    return new VerifiedOrganisations(
      id,
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
      organisationName,
      domainName,
      mainContactName,
      mainContactEmail,
      mainContactPhone,
      address);
  }
  public interface BuildStep {
    VerifiedOrganisations build();
    BuildStep id(String id);
    BuildStep organisationName(String organisationName);
    BuildStep domainName(String domainName);
    BuildStep mainContactName(String mainContactName);
    BuildStep mainContactEmail(String mainContactEmail);
    BuildStep mainContactPhone(String mainContactPhone);
    BuildStep address(String address);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String organisationName;
    private String domainName;
    private String mainContactName;
    private String mainContactEmail;
    private String mainContactPhone;
    private String address;
    @Override
     public VerifiedOrganisations build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new VerifiedOrganisations(
          id,
          organisationName,
          domainName,
          mainContactName,
          mainContactEmail,
          mainContactPhone,
          address);
    }
    
    @Override
     public BuildStep organisationName(String organisationName) {
        this.organisationName = organisationName;
        return this;
    }
    
    @Override
     public BuildStep domainName(String domainName) {
        this.domainName = domainName;
        return this;
    }
    
    @Override
     public BuildStep mainContactName(String mainContactName) {
        this.mainContactName = mainContactName;
        return this;
    }
    
    @Override
     public BuildStep mainContactEmail(String mainContactEmail) {
        this.mainContactEmail = mainContactEmail;
        return this;
    }
    
    @Override
     public BuildStep mainContactPhone(String mainContactPhone) {
        this.mainContactPhone = mainContactPhone;
        return this;
    }
    
    @Override
     public BuildStep address(String address) {
        this.address = address;
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
    private CopyOfBuilder(String id, String organisationName, String domainName, String mainContactName, String mainContactEmail, String mainContactPhone, String address) {
      super.id(id);
      super.organisationName(organisationName)
        .domainName(domainName)
        .mainContactName(mainContactName)
        .mainContactEmail(mainContactEmail)
        .mainContactPhone(mainContactPhone)
        .address(address);
    }
    
    @Override
     public CopyOfBuilder organisationName(String organisationName) {
      return (CopyOfBuilder) super.organisationName(organisationName);
    }
    
    @Override
     public CopyOfBuilder domainName(String domainName) {
      return (CopyOfBuilder) super.domainName(domainName);
    }
    
    @Override
     public CopyOfBuilder mainContactName(String mainContactName) {
      return (CopyOfBuilder) super.mainContactName(mainContactName);
    }
    
    @Override
     public CopyOfBuilder mainContactEmail(String mainContactEmail) {
      return (CopyOfBuilder) super.mainContactEmail(mainContactEmail);
    }
    
    @Override
     public CopyOfBuilder mainContactPhone(String mainContactPhone) {
      return (CopyOfBuilder) super.mainContactPhone(mainContactPhone);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
  }
  
}
