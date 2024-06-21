package com.ecoleit.linkedin.profile.service;

import com.ecoleit.linkedin.profile.entity.Experience;
import com.ecoleit.linkedin.profile.entity.Profile;
import com.ecoleit.linkedin.profile.modele.ExperienceDTO;
import com.ecoleit.linkedin.profile.repository.ExperienceRepository;
import com.ecoleit.linkedin.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final ProfileRepository profileRepository;

    public ExperienceService(ExperienceRepository experienceRepository,
                             ProfileRepository profileRepository) {
        this.experienceRepository = experienceRepository;
        this.profileRepository = profileRepository;
    }

    public ExperienceDTO convertToExperienceDTO(Experience experience){
        return  new ExperienceDTO(
                experience.getId(),
                experience.getJobTitle(),
                experience.getCompanyName(),
                experience.getLocation(),
                experience.getStartDate(),
                experience.getEndDate());
    }

    public List<ExperienceDTO> getExperienceList(){
        return experienceRepository
                .findAll()
                .stream()
                .map(this::convertToExperienceDTO)
                .toList();
    }
    public List<ExperienceDTO> getExperienceListByUserId(Integer userId){
        Profile profile = CommonService.getProfileByUserId(userId);
        return profile.getExperiences()
                .stream()
                .map(this::convertToExperienceDTO)
                .toList();
    }
    public ExperienceDTO createExperience(Integer userId,
                                          ExperienceDTO experienceDTO){
        Profile profile = CommonService.getProfileByUserId(userId);
        Experience newExperience = new Experience();
        newExperience.setJobTitle(experienceDTO.jobTitle());
        newExperience.setCompanyName(experienceDTO.companyName());
        newExperience.setLocation(experienceDTO.location());
        newExperience.setStartDate(experienceDTO.startDate());
        newExperience.setEndDate(experienceDTO.endDate());
        newExperience.setProfile(profile);
        experienceRepository.save(newExperience);
        profile.getExperiences().add(newExperience);
        profileRepository.save(profile);
        return convertToExperienceDTO(newExperience);
    }

    public ExperienceDTO updateExperience(Integer userId,
                                          Integer experienceId,
                                          ExperienceDTO experienceDTO){
        Profile profile = CommonService.getProfileByUserId(userId);
        Experience experience = profile
                .getExperiences()
                .stream()
                .filter(exp -> exp.getId()==experienceId)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Experience not found"));
        experience.setJobTitle(experienceDTO.jobTitle());
        experience.setCompanyName(experienceDTO.companyName());
        experience.setLocation(experienceDTO.location());
        experience.setStartDate(experienceDTO.startDate());
        experience.setEndDate(experienceDTO.endDate());
        experienceRepository.save(experience);
        return convertToExperienceDTO(experience);
    }

    public void deleteExperience(Integer userId, Integer experienceId) {
        if (!experienceRepository.existsById(experienceId)){
            throw new IllegalArgumentException("Experience not found");
        }
        Profile profile = CommonService.getProfileByUserId(userId);
        profile.getExperiences()
                        .removeIf(exp -> exp.getId()==experienceId);
        experienceRepository.deleteById(experienceId);
        profileRepository.save(profile);
    }

}
