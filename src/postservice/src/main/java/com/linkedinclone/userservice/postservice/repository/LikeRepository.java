package com.linkedinclone.userservice.postservice.repository;

import com.linkedinclone.userservice.postservice.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    // Custom query methods can be added here if needed
    // For example:
    // List<Like> findByPostId(Integer postId);
    // List<Like> findByUserId(Integer userId);
}
