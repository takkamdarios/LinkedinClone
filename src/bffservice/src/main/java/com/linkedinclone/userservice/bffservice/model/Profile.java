package com.linkedinclone.userservice.bffservice.model;

import java.util.Objects;

public class Profile {

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
    public Profile() {
    }

    // Constructor with fields
    public Profile(Long userId, String firstName, String lastName, String email,
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

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String currentJobTitle) {
        this.currentJobTitle = currentJobTitle;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isOpenForWork() {
        return openForWork;
    }

    public void setOpenForWork(boolean openForWork) {
        this.openForWork = openForWork;
    }

    // toString method
    @Override
    public String toString() {
        return "Profile{" +
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
        Profile profile = (Profile) o;
        return openForWork == profile.openForWork &&
                Objects.equals(userId, profile.userId) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(email, profile.email) &&
                Objects.equals(phoneNumber, profile.phoneNumber) &&
                Objects.equals(headline, profile.headline) &&
                Objects.equals(summary, profile.summary) &&
                Objects.equals(industry, profile.industry) &&
                Objects.equals(currentJobTitle, profile.currentJobTitle) &&
                Objects.equals(website, profile.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, phoneNumber, headline, summary, industry, currentJobTitle, website, openForWork);
    }
}
