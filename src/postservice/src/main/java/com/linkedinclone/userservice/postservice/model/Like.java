package com.linkedinclone.userservice.postservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    // Assuming we are auto-generating the creation date when the record is persisted
    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    // Constructors
    public Like() {
        // Default constructor
    }

    public Like(Long id, Long postId, Long userId) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        // The creation date is auto-set to now
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    // Set the Creation Date
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

}
