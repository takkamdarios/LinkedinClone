package com.linkedinclone.userservice.bffservice.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostDTO {

    private Long id;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime creationDate;

    // Default constructor
    public PostDTO() {
    }

    // Constructor with fields
    public PostDTO(Long id, Long userId, String title, String content, LocalDateTime creationDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    // Getters and Setters
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    // toString method
    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return Objects.equals(id, postDTO.id) &&
                Objects.equals(userId, postDTO.userId) &&
                Objects.equals(title, postDTO.title) &&
                Objects.equals(content, postDTO.content) &&
                Objects.equals(creationDate, postDTO.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, content, creationDate);
    }
}
