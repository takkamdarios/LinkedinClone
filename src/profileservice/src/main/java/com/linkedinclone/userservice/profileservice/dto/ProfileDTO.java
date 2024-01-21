package com.linkedinclone.userservice.profileservice.dto;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

public class ProfileDTO {

    @Schema(description = "Unique identifier of the profile.", example = "101", required = true)
    private Long id;

    @Schema(description = "User ID associated with this profile.", example = "1", required = true)
    private Long userId;
    private String currentJobTitle;
    private String industry;
    private String summary;
    private String headline;
    private String website;
    private boolean openForWork;
    private List<EducationDTO> education;
    private List<ExperienceDTO> experience;
    private List<String> skills;

    // Default constructor
    public ProfileDTO() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String currentJobTitle) {
        this.currentJobTitle = currentJobTitle;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
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

    public List<EducationDTO> getEducation() {
        return education;
    }

    public void setEducation(List<EducationDTO> education) {
        this.education = education;
    }

    public List<ExperienceDTO> getExperience() {
        return experience;
    }

    public void setExperience(List<ExperienceDTO> experience) {
        this.experience = experience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

}
