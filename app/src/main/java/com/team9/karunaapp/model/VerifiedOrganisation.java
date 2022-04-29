package com.team9.karunaapp.model;

public class VerifiedOrganisation {

    private String organisationName;
    private String domainName;
    private String mainContactName;
    private String mainContactEmail;
    private String mainContactPhone;
    private String address;

    public VerifiedOrganisation() {
    }

    public VerifiedOrganisation(String organisationName, String domainName, String mainContactName, String mainContactEmail, String mainContactPhone, String address) {
        this.organisationName = organisationName;
        this.domainName = domainName;
        this.mainContactName = mainContactName;
        this.mainContactEmail = mainContactEmail;
        this.mainContactPhone = mainContactPhone;
        this.address = address;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getMainContactName() {
        return mainContactName;
    }

    public void setMainContactName(String mainContactName) {
        this.mainContactName = mainContactName;
    }

    public String getMainContactEmail() {
        return mainContactEmail;
    }

    public void setMainContactEmail(String mainContactEmail) {
        this.mainContactEmail = mainContactEmail;
    }

    public String getMainContactPhone() {
        return mainContactPhone;
    }

    public void setMainContactPhone(String mainContactPhone) {
        this.mainContactPhone = mainContactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
