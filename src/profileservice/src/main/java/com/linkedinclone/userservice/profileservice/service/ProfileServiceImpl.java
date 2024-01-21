package com.linkedinclone.userservice.profileservice.service;

import com.linkedinclone.userservice.profileservice.dto.ProfileDTO;
import com.linkedinclone.userservice.profileservice.model.Profile;
import com.linkedinclone.userservice.profileservice.repository.ProfileRepository;
import com.linkedinclone.userservice.profileservice.service.ProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        BeanUtils.copyProperties(profileDTO, profile);
        profile = profileRepository.save(profile);
        BeanUtils.copyProperties(profile, profileDTO);
        return profileDTO;
    }

    @Override
    public Optional<ProfileDTO> getProfileById(Long id) {
        return profileRepository.findById(id).map(profile -> {
            ProfileDTO profileDTO = new ProfileDTO();
            BeanUtils.copyProperties(profile, profileDTO);
            return profileDTO;
        });
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll().stream().map(profile -> {
            ProfileDTO profileDTO = new ProfileDTO();
            BeanUtils.copyProperties(profile, profileDTO);
            return profileDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) {
        return profileRepository.findById(id).map(profile -> {
            BeanUtils.copyProperties(profileDTO, profile);
            profile = profileRepository.save(profile);
            ProfileDTO updatedProfileDTO = new ProfileDTO();
            BeanUtils.copyProperties(profile, updatedProfileDTO);
            return updatedProfileDTO;
        }).orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    @Override
    public void deleteProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
        profileRepository.delete(profile);
    }

}
