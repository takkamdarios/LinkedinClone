package com.linkedinclone.userservice.postservice.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;  // Assuming 'user_id' is the identifier for the user from the User microservice

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "parent_comment_id")
    private Integer parentCommentId; // For nested comments, if this is a reply to another comment

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    // Default constructor
    public Comment() {
    }

    // Parametrized constructor
    public Comment(Integer id, Integer postId, Integer userId, String content, Integer parentCommentId, LocalDateTime creationDate) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.parentCommentId = parentCommentId;
        this.creationDate = creationDate;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
