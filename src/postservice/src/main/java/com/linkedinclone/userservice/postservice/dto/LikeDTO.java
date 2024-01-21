package com.linkedinclone.userservice.postservice.dto;

import java.time.LocalDateTime;

public class LikeDTO {

    private Long id;
    private Long postId;
    private Long userId;
    private Long profileId; // Assuming profileId maps to userId in the Like entity
    private LocalDateTime creationDate;

    // Default constructor
    public LikeDTO() {
    }

    // Parameterized constructor
    public LikeDTO(Long id, Long postId, Long profileId) {
        this.id = id;
        this.postId = postId;
        this.profileId = profileId;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getProfileId() {
        return profileId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "LikeDTO{" +
                "id=" + id +
                ", postId=" + postId +
                ", profileId=" + profileId +
                '}';
    }
    // Get the User ID
    public Long getUserId() {
        return userId;
    }

    // Set the User ID
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Get the Creation Date
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    // Set the Creation Date
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

}
