package com.linkedinclone.userservice.profileservice.controller;

import com.linkedinclone.userservice.profileservice.dto.ProfileDTO;
import com.linkedinclone.userservice.profileservice.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@Tag(name = "Profile", description = "Operations related to user profile management.")
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @Operation(
            summary = "Create Profile",
            description = "Create a new profile for a user.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Profile created successfully."),
                    @ApiResponse(responseCode = "400", description = "Invalid profile data.")
            }
    )
    @PostMapping
    public ResponseEntity<ProfileDTO> createProfile(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Profile information for creating a new profile.", content = @Content(schema = @Schema(implementation = ProfileDTO.class))) @RequestBody ProfileDTO profileDTO) {
        ProfileDTO createdProfile = profileService.createProfile(profileDTO);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }


    @Operation(summary = "Get Profile", description = "Retrieve a user's profile by profile ID.")
    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@Parameter(description = "Unique ID of the profile to be retrieved.") @PathVariable Long id) {
        return profileService.getProfileById(id)
                .map(profileDTO -> new ResponseEntity<>(profileDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(summary = "Get All Profiles", description = "Retrieve profiles of all users.")
    @GetMapping
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        List<ProfileDTO> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }


    @Operation(summary = "Update Profile", description = "Update an existing user's profile.")
    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO) {
        try {
            ProfileDTO updatedProfile = profileService.updateProfile(id, profileDTO);
            return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Operation(summary = "Delete Profile", description = "Delete a user's profile.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        try {
            profileService.deleteProfile(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
