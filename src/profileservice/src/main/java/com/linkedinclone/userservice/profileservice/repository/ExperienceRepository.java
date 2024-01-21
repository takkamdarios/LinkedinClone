package com.linkedinclone.userservice.profileservice.repository;

import com.linkedinclone.userservice.profileservice.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    // Find experience records by profile ID
    List<Experience> findByProfileId(Long profileId);

}
