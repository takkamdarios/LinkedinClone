package com.ecoleit.linkedin.profile.repository;

import com.ecoleit.linkedin.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findByUserId(Integer userId);
}
