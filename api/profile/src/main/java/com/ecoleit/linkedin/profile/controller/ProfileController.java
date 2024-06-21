package com.ecoleit.linkedin.profile.controller;

import com.ecoleit.linkedin.profile.modele.*;
import com.ecoleit.linkedin.profile.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    private final ProfileService profileService;
    private final ExperienceService experienceService;
    private final EducationService educationService;
    private final SkillService skillService;
    private final ConnectionService connectionService;

    public ProfileController(ProfileService profileService,
                             ExperienceService experienceService,
                             EducationService educationService,
                             SkillService skillService,
                             ConnectionService connectionService) {
        this.profileService = profileService;
        this.experienceService = experienceService;
        this.educationService = educationService;
        this.skillService = skillService;
        this.connectionService = connectionService;
    }

    @GetMapping("")
    List<FullProfileDTO> getProfileList(){
        return profileService.getProfileList();
    }

    @GetMapping("/{profileId}")
    FullProfileDTO getProfileById(@PathVariable Integer profileId ){
        return profileService.getFullProfileById(profileId);
    }

    @GetMapping("/user/{userId}")
    FullProfileDTO getProfileByUserId(@PathVariable Integer userId){
        return profileService.getFullProfileByUserId(userId);
    }

    @PutMapping("/user/{userId}")
    FullProfileDTO updateProfile(@PathVariable Integer userId,
                             @RequestBody ProfileDTO profileDTO){
        return profileService.updateProfile(userId, profileDTO);
    }

    @PostMapping("")
    FullProfileDTO createProfile(@RequestBody ProfileDTO profileDTO){
        return profileService.createProfile(profileDTO);
    }

    //####### Experience ########
    @GetMapping("/user/{userId}/experiences")
    List<ExperienceDTO> getExperienceListByUserId(@PathVariable Integer userId){
        return  experienceService.getExperienceListByUserId(userId);
    }

    @PostMapping("/user/{userId}/experiences")
    ExperienceDTO createExperience(
            @PathVariable Integer userId,
            @RequestBody ExperienceDTO experienceDTO){
        return experienceService.createExperience(userId, experienceDTO);
    }

    @PutMapping("/user/{userId}/experiences/{experienceId}")
    ExperienceDTO updateExperience(
            @PathVariable Integer userId,
            @PathVariable Integer experienceId,
            @RequestBody ExperienceDTO experienceDTO){
        return experienceService.updateExperience(userId, experienceId, experienceDTO);
    }
    @DeleteMapping("/user/{userId}/experiences/{experienceId}")
    ResponseEntity<String> deleteExperience(
            @PathVariable Integer userId,
            @PathVariable Integer experienceId) {
        experienceService.deleteExperience(userId, experienceId);
        return ResponseEntity.ok("Experience deleted");
    }

    //####### Education ########
    //FETCH
    @GetMapping("/user/{userId}/educations")
    List<EducationDTO> getEducationListByUserId(@PathVariable Integer userId){
        return  educationService.getEducationListByUserId(userId);
    }
    // CREATE
    @PostMapping("/user/{userId}/educations")
    EducationDTO createEducation(
            @PathVariable Integer userId,
            @RequestBody EducationDTO educationDTO){
        return educationService.createEducation(userId, educationDTO);
    }
    // UPDATE
    @PutMapping("/user/{userId}/educations/{educationId}")
    EducationDTO updateEducation(
            @PathVariable Integer userId,
            @PathVariable Integer educationId,
            @RequestBody EducationDTO educationDTO){
        return educationService.updateEducation(userId, educationId, educationDTO);
    }
    // DELETE
    @DeleteMapping("/user/{userId}/educations/{educationId}")
    ResponseEntity<?> deleteEducation(
            @PathVariable Integer userId,
            @PathVariable Integer educationId) {
        educationService.deleteEducation(userId, educationId);
        return ResponseEntity.ok("Education deleted");
    }

    //####### Connection ########
    @GetMapping("/user/{userId}/connections")
    List<ProfileDTO> getConnectionListByUserId(@PathVariable Integer userId){
        return  connectionService.getConnectionListByUserId(userId);
    }
    // CREATE
    @PostMapping("/user/{userId}/connections")
    ResponseEntity<?> addConnection(
            @PathVariable Integer userId,
            @RequestParam Integer otherUserId){
        connectionService.addConnection(userId, otherUserId);
        return ResponseEntity.ok("Connection added");
    }
    // DELETE
    @DeleteMapping("/user/{userId}/connections")
    ResponseEntity<?> removeConnection(
            @PathVariable Integer userId,
            @RequestParam Integer otherUserId){
        connectionService.removeConnection(userId, otherUserId);
        return  ResponseEntity.ok("Connection deleted");
    }

    //####### Skill ########
    //FETCH
    @GetMapping("/user/{userId}/skills")
    List<SkillDTO> getSkillListByUserId(@PathVariable Integer userId){
        return  skillService.getSkillListByUserId(userId);
    }
    // CREATE
    @PostMapping("/user/{userId}/skills")
    SkillDTO createSkill(
            @PathVariable Integer userId,
            @RequestBody SkillDTO skillDTO){
        return skillService.createSkill(userId, skillDTO);
    }
    // UPDATE
    @PutMapping("/user/{userId}/skills/{skillId}")
    SkillDTO updateSkill(
            @PathVariable Integer userId,
            @PathVariable Integer skillId,
            @RequestBody SkillDTO skillDTO){
        return skillService.updateSkill(userId, skillId, skillDTO);
    }
    // DELETE
    @DeleteMapping("/user/{userId}/skills/{skillId}")
    ResponseEntity<?> deleteSkill(
            @PathVariable Integer userId,
            @PathVariable Integer skillId) {
        skillService.deleteSkill(userId, skillId);
        return ResponseEntity.ok("Skill deleted");
    }
}
