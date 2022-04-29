package com.team9.karunaapp.model;

import com.amplifyframework.core.model.temporal.Temporal;

public class LocatedPerson {

    private Temporal.Date dateEntered;
    private String surname;
    private String firstName;
    private String location;
    private String status;
    private Boolean hasPhoto;

    public LocatedPerson() {
    }

    public LocatedPerson(Temporal.Date dateEntered, String surname, String firstName, String location, String status, Boolean hasPhoto) {
        this.dateEntered = dateEntered;
        this.surname = surname;
        this.firstName = firstName;
        this.location = location;
        this.status = status;
        this.hasPhoto = hasPhoto;
    }

    public Temporal.Date getDate() {
        return dateEntered;
    }

    public void setDate(Temporal.Date date) {
        this.dateEntered = date;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
    }
}
