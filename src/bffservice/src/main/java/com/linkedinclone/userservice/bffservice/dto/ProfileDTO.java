package com.linkedinclone.userservice.bffservice.dto;

import java.util.Objects;

public class ProfileDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String headline;
    private String summary;
    private String industry;
    private String currentJobTitle;
    private String website;
    private boolean openForWork;

    // Default constructor
    public ProfileDTO() {
    }

    // Constructor with fields
    public ProfileDTO(Long userId, String firstName, String lastName, String email,
                      String phoneNumber, String headline, String summary,
                      String industry, String currentJobTitle, String website, boolean openForWork) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.headline = headline;
        this.summary = summary;
        this.industry = industry;
        this.currentJobTitle = currentJobTitle;
        this.website = website;
        this.openForWork = openForWork;
    }



    // Getters
    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSummary() {
        return summary;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public String getWebsite() {
        return website;
    }

    public boolean isOpenForWork() {
        return openForWork;
    }

    // Setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setCurrentJobTitle(String currentJobTitle) {
        this.currentJobTitle = currentJobTitle;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setOpenForWork(boolean openForWork) {
        this.openForWork = openForWork;
    }


    // toString method
    @Override
    public String toString() {
        return "ProfileDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", headline='" + headline + '\'' +
                ", summary='" + summary + '\'' +
                ", industry='" + industry + '\'' +
                ", currentJobTitle='" + currentJobTitle + '\'' +
                ", website='" + website + '\'' +
                ", openForWork=" + openForWork +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDTO that = (ProfileDTO) o;
        return openForWork == that.openForWork &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(headline, that.headline) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(industry, that.industry) &&
                Objects.equals(currentJobTitle, that.currentJobTitle) &&
                Objects.equals(website, that.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, phoneNumber, headline, summary, industry, currentJobTitle, website, openForWork);
    }
}
