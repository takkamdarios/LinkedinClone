package com.linkedinclone.userservice.postservice.repository;

import com.linkedinclone.userservice.postservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // Custom query methods can be added here if needed
    // For example:
    // List<Comment> findByPostId(Integer postId);
}
