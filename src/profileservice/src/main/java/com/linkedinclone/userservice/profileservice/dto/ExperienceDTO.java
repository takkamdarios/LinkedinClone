package com.linkedinclone.userservice.profileservice.dto;

import java.time.LocalDate;

public class ExperienceDTO {

    private Long id;
    private Long profileId;
    private String jobTitle;
    private String companyName;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    // Default constructor
    public ExperienceDTO() {
    }

    // Constructor with all fields
    public ExperienceDTO(Long id, Long profileId, String jobTitle, String companyName, String location, LocalDate startDate, LocalDate endDate, String description) {
        this.id = id;
        this.profileId = profileId;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
