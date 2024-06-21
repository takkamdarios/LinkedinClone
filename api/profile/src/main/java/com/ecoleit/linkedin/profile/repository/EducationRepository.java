package com.ecoleit.linkedin.profile.repository;

import com.ecoleit.linkedin.profile.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
}
