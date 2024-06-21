package com.ecoleit.linkedin.profile.entity;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "profiles", schema = "linkedin_profile", catalog = "")
public class Profile {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "current_job_title")
    private String currentJobTitle;
    @Basic
    @Column(name = "industry")
    private String industry;
    @Basic
    @Column(name = "summary")
    private String summary;
    @Basic
    @Column(name = "headline")
    private String headline;
    @Basic
    @Column(name = "website")
    private String website;
    @Basic
    @Column(name = "open_for_work")
    private int openForWork;

    @OneToMany(mappedBy = "profile")
    private Set<Education> educations;

    @OneToMany(mappedBy = "profile")
    private Set<Experience> experiences;


    @ManyToMany
    @JoinTable(name = "profiles_skills",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    @ManyToMany
    @JoinTable(name = "profiles_connections",
            joinColumns = @JoinColumn(name = "profile1_id"),
            inverseJoinColumns = @JoinColumn(name = "profile2_id")
    )
    private Set<Profile> connections;

    public Set<Profile> getConnections() {
        return connections;
    }

    public void setConnections(Set<Profile> connections) {
        this.connections = connections;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public int getOpenForWork() {
        return openForWork;
    }

    public void setOpenForWork(int openForWork) {
        this.openForWork = openForWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return id == profile.id && userId == profile.userId && openForWork == profile.openForWork
                && Objects.equals(currentJobTitle, profile.currentJobTitle)
                && Objects.equals(industry, profile.industry) && Objects.equals(summary, profile.summary)
                && Objects.equals(headline, profile.headline) && Objects.equals(website, profile.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, currentJobTitle, industry, summary, headline, website, openForWork);
    }
}
