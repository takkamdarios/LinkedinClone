package com.linkedinclone.userservice.postservice.repository;

import com.linkedinclone.userservice.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // Custom query methods can be added here if needed
    // For example:
    // List<Post> findByUserId(Integer userId);
}
