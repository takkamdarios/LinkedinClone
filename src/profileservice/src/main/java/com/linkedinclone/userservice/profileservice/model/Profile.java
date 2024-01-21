package com.linkedinclone.userservice.profileservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "current_job_title", nullable = false)
    private String currentJobTitle;

    @Column(name = "industry")
    private String industry;

    @Column(name = "summary")
    private String summary;

    @Column(name = "headline", nullable = false)
    private String headline;

    @Column(name = "website")
    private String website;

    @Column(name = "open_for_work")
    private boolean openForWork;

    // Assuming we have entities for Education and Experience
    @OneToMany(mappedBy = "profileId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> education;

    @OneToMany(mappedBy = "profileId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experience> experience;

    // Default constructor
    public Profile() {
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

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

}
