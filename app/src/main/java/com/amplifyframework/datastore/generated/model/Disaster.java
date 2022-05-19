package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
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

/** This is an auto generated class representing the Disaster type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Disasters", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Disaster implements Model {
  public static final QueryField ID = field("Disaster", "id");
  public static final QueryField LOCATION_NAME = field("Disaster", "locationName");
  public static final QueryField LATITUDE = field("Disaster", "latitude");
  public static final QueryField LONGITUDE = field("Disaster", "longitude");
  public static final QueryField AFFECTED_DISTANCE_FROM_LOCATION = field("Disaster", "affectedDistanceFromLocation");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String locationName;
  private final @ModelField(targetType="Float") Double latitude;
  private final @ModelField(targetType="Float") Double longitude;
  private final @ModelField(targetType="Int") Integer affectedDistanceFromLocation;
  private final @ModelField(targetType="LocatedPersons") @HasMany(associatedWith = "disasterID", type = LocatedPersons.class) List<LocatedPersons> fk_disaster = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getLocationName() {
      return locationName;
  }
  
  public Double getLatitude() {
      return latitude;
  }
  
  public Double getLongitude() {
      return longitude;
  }
  
  public Integer getAffectedDistanceFromLocation() {
      return affectedDistanceFromLocation;
  }
  
  public List<LocatedPersons> getFkDisaster() {
      return fk_disaster;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Disaster(String id, String locationName, Double latitude, Double longitude, Integer affectedDistanceFromLocation) {
    this.id = id;
    this.locationName = locationName;
    this.latitude = latitude;
    this.longitude = longitude;
    this.affectedDistanceFromLocation = affectedDistanceFromLocation;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Disaster disaster = (Disaster) obj;
      return ObjectsCompat.equals(getId(), disaster.getId()) &&
              ObjectsCompat.equals(getLocationName(), disaster.getLocationName()) &&
              ObjectsCompat.equals(getLatitude(), disaster.getLatitude()) &&
              ObjectsCompat.equals(getLongitude(), disaster.getLongitude()) &&
              ObjectsCompat.equals(getAffectedDistanceFromLocation(), disaster.getAffectedDistanceFromLocation()) &&
              ObjectsCompat.equals(getCreatedAt(), disaster.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), disaster.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getLocationName())
      .append(getLatitude())
      .append(getLongitude())
      .append(getAffectedDistanceFromLocation())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Disaster {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("locationName=" + String.valueOf(getLocationName()) + ", ")
      .append("latitude=" + String.valueOf(getLatitude()) + ", ")
      .append("longitude=" + String.valueOf(getLongitude()) + ", ")
      .append("affectedDistanceFromLocation=" + String.valueOf(getAffectedDistanceFromLocation()) + ", ")
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
  public static Disaster justId(String id) {
    return new Disaster(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      locationName,
      latitude,
      longitude,
      affectedDistanceFromLocation);
  }
  public interface BuildStep {
    Disaster build();
    BuildStep id(String id);
    BuildStep locationName(String locationName);
    BuildStep latitude(Double latitude);
    BuildStep longitude(Double longitude);
    BuildStep affectedDistanceFromLocation(Integer affectedDistanceFromLocation);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String locationName;
    private Double latitude;
    private Double longitude;
    private Integer affectedDistanceFromLocation;
    @Override
     public Disaster build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Disaster(
          id,
          locationName,
          latitude,
          longitude,
          affectedDistanceFromLocation);
    }
    
    @Override
     public BuildStep locationName(String locationName) {
        this.locationName = locationName;
        return this;
    }
    
    @Override
     public BuildStep latitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }
    
    @Override
     public BuildStep longitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
    
    @Override
     public BuildStep affectedDistanceFromLocation(Integer affectedDistanceFromLocation) {
        this.affectedDistanceFromLocation = affectedDistanceFromLocation;
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
    private CopyOfBuilder(String id, String locationName, Double latitude, Double longitude, Integer affectedDistanceFromLocation) {
      super.id(id);
      super.locationName(locationName)
        .latitude(latitude)
        .longitude(longitude)
        .affectedDistanceFromLocation(affectedDistanceFromLocation);
    }
    
    @Override
     public CopyOfBuilder locationName(String locationName) {
      return (CopyOfBuilder) super.locationName(locationName);
    }
    
    @Override
     public CopyOfBuilder latitude(Double latitude) {
      return (CopyOfBuilder) super.latitude(latitude);
    }
    
    @Override
     public CopyOfBuilder longitude(Double longitude) {
      return (CopyOfBuilder) super.longitude(longitude);
    }
    
    @Override
     public CopyOfBuilder affectedDistanceFromLocation(Integer affectedDistanceFromLocation) {
      return (CopyOfBuilder) super.affectedDistanceFromLocation(affectedDistanceFromLocation);
    }
  }
  
}
