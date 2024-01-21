package com.linkedinclone.userservice.bffservice.controller;

import com.linkedinclone.userservice.bffservice.dto.ProfileDTO;
import com.linkedinclone.userservice.bffservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Get a user's profile
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileDTO> getProfileByUserId(@PathVariable Long userId) {
        ProfileDTO profile = profileService.getProfileByUserId(userId);
        return ResponseEntity.ok(profile);
    }

    // Update a user's profile
    @PutMapping("/{userId}")
    public ResponseEntity<ProfileDTO> updateProfile(@PathVariable Long userId, @RequestBody ProfileDTO profileDto) {
        ProfileDTO updatedProfile = profileService.updateProfile(userId, profileDto);
        return ResponseEntity.ok(updatedProfile);
    }

    // Additional methods and endpoints can be added as per your application's requirements...

}
