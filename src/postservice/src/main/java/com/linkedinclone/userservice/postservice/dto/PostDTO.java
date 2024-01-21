package com.linkedinclone.userservice.postservice.dto;
import java.time.LocalDateTime;

public class PostDTO {
    private Long id;
    private Long profileId;
    private String title;
    private String content;
    private LocalDateTime creationDate;

    // Getters
    public Long getId() {
        return id;
    }

    public Long getProfileId() {
        return profileId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
