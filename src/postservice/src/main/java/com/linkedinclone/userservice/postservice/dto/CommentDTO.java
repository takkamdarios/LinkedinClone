package com.linkedinclone.userservice.postservice.dto;

import java.time.LocalDateTime;

public class CommentDTO {

    private Long id;
    private Long postId;
    private Long userId; // Changed from profileId to userId to align with your architecture
    private String content;
    private LocalDateTime creationDate;

    // Default constructor
    public CommentDTO() {
    }

    // Parameterized constructor
    public CommentDTO(Long id, Long postId, Long userId, String content, LocalDateTime creationDate) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.creationDate = creationDate;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getUserId() {
        return userId;
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

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    private Long parentCommentId; // Add this line to your CommentDTO class

    // Corresponding getter and setter
    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

}
