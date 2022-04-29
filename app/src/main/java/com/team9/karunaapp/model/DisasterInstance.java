package com.team9.karunaapp.model;

public class DisasterInstance {

    private String locationName;
    private Integer affectedDistanceFromLocation;
    private Double latitude;
    private Double longitude;

    public DisasterInstance() {
    }

    public DisasterInstance(String locationName, Integer affectedDistanceFromLocation) {
        this.locationName = locationName;
        this.affectedDistanceFromLocation = affectedDistanceFromLocation;
    }

    public DisasterInstance(String locationName, Integer affectedDistanceFromLocation, Double latitude, Double longitude) {
        this.locationName = locationName;
        this.affectedDistanceFromLocation = affectedDistanceFromLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Integer getAffectedDistanceFromLocation() {
        return affectedDistanceFromLocation;
    }

    public void setAffectedDistanceFromLocation(Integer affectedDistanceFromLocation) {
        this.affectedDistanceFromLocation = affectedDistanceFromLocation;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
