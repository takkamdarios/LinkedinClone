package com.ecoleit.linkedin.profile.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "educations", schema = "linkedin_profile", catalog = "")
public class Education {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "school")
    private String school;
    @Basic
    @Column(name = "degree")
    private String degree;
    @Basic
    @Column(name = "field_of_study")
    private String filedOfStudy;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFiledOfStudy() {
        return filedOfStudy;
    }

    public void setFiledOfStudy(String filedOfStudy) {
        this.filedOfStudy = filedOfStudy;
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
        if (!(o instanceof Education education)) return false;
        return id == education.id && Objects.equals(school, education.school)
                && Objects.equals(degree, education.degree)
                && Objects.equals(filedOfStudy, education.filedOfStudy)
                && Objects.equals(startDate, education.startDate)
                && Objects.equals(endDate, education.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, school, degree, filedOfStudy, startDate, endDate);
    }
}
