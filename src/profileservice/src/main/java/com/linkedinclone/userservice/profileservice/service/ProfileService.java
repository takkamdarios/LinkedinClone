package com.linkedinclone.userservice.profileservice.service;

import com.linkedinclone.userservice.profileservice.dto.ProfileDTO;
import java.util.List;
import java.util.Optional;

public interface ProfileService {

    ProfileDTO createProfile(ProfileDTO profileDTO);

    Optional<ProfileDTO> getProfileById(Long id);

    List<ProfileDTO> getAllProfiles();

    ProfileDTO updateProfile(Long id, ProfileDTO profileDTO);

    void deleteProfile(Long id);

}
