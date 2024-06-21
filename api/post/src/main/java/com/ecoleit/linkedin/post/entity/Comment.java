package com.ecoleit.linkedin.post.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "linkedin_post", catalog = "")
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "profile_id")
    private int profileId;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment comment)) return false;
        return id == comment.id && profileId == comment.profileId
                && Objects.equals(content, comment.content)
                && Objects.equals(creationDate, comment.creationDate)
                && Objects.equals(post, comment.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profileId, content, creationDate, post);
    }
}
