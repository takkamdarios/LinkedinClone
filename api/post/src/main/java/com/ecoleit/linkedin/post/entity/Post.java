package com.ecoleit.linkedin.post.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "posts", schema = "linkedin_post", catalog = "")
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "profile_id")
    private int profileId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return id == post.id && profileId == post.profileId
                && Objects.equals(title, post.title)
                && Objects.equals(content, post.content)
                && Objects.equals(creationDate, post.creationDate)
                && Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profileId, title, content, creationDate, comments);
    }
}
