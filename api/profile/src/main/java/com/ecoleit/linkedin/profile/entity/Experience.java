package com.ecoleit.linkedin.profile.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "experiences", schema = "linkedin_profile", catalog = "")
public class Experience {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "job_title")
    private String jobTitle;
    @Basic
    @Column(name = "company_name")
    private String companyName;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Experience experience)) return false;
        return id == experience.id && Objects.equals(jobTitle, experience.jobTitle)
                && Objects.equals(companyName, experience.companyName)
                && Objects.equals(location, experience.location)
                && Objects.equals(startDate, experience.startDate)
                && Objects.equals(endDate, experience.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobTitle, companyName, location, startDate, endDate);
    }
}
