package com.ecoleit.linkedin.bff.controller;

import com.ecoleit.linkedin.bff.model.*;
import com.ecoleit.linkedin.bff.model.api.FullProfileApiDTO;
import com.ecoleit.linkedin.bff.model.api.ProfileApiDTO;
import com.ecoleit.linkedin.bff.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/api

@RestController
@RequestMapping("/api/profiles")
public class ProfileBffController {
    private final ProfileService profileService;

    public ProfileBffController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/user/{userId}")
    public FullProfileDTO getProfileByUserId(@PathVariable Integer userId) {
        return profileService.getProfileByUserId(userId);
    }

    @GetMapping("/{profileId}")
    public FullProfileDTO getProfileById(@PathVariable Integer profileId) {
        return profileService.getProfileById(profileId);
    }

    @PostMapping("")
    public FullProfileApiDTO createProfile(@RequestBody ProfileApiDTO profileApiDTO) {
        return profileService.createProfile(profileApiDTO);
    }

    @PutMapping("/user/{userId}")
    public FullProfileApiDTO updateProfile(@RequestBody ProfileApiDTO profileApiDTO, @PathVariable Integer userId) {
        return profileService.updateProfile(userId, profileApiDTO);
    }

    @DeleteMapping("/user/{userId}/skills/{skillId}")
    ResponseEntity<String> deleteSkill(@PathVariable Integer userId, @PathVariable Integer skillId) {
        if (profileService.deleteSkill(userId, skillId)) {
            return ResponseEntity.ok("Skill deleted");
        }
        return ResponseEntity.notFound().build();
    }
}
