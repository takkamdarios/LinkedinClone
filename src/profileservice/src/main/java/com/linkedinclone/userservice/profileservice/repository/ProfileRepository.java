package com.linkedinclone.userservice.profileservice.repository;

import com.linkedinclone.userservice.profileservice.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    // Find a profile by the user ID
    Profile findByUserId(Long userId);

}
