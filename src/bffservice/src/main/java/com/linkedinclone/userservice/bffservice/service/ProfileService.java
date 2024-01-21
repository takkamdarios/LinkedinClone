package com.linkedinclone.userservice.bffservice.service;

import com.linkedinclone.userservice.bffservice.dto.ProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileService {

    private final RestTemplate restTemplate;
    private final String profileServiceUrl = "http://localhost:8079/"; // URL of the Profile microservice

    @Autowired
    public ProfileService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProfileDTO getProfileByUserId(Long userId) {
        // Retrieve a user's profile by user ID
        return restTemplate.getForObject(profileServiceUrl + "/" + userId, ProfileDTO.class);
    }

    public ProfileDTO updateProfile(Long userId, ProfileDTO profileDto) {
        // Update a user's profile
        restTemplate.put(profileServiceUrl + "/" + userId, profileDto);
        return profileDto; // Assuming the profile is updated correctly
    }

}
