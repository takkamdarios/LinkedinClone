package com.linkedinclone.userservice.profileservice.repository;

import com.linkedinclone.userservice.profileservice.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

    // Find education records by profile ID
    List<Education> findByProfileId(Long profileId);

}
