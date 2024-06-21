package com.ecoleit.linkedin.profile.repository;

import com.ecoleit.linkedin.profile.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
