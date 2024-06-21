package com.ecoleit.linkedin.profile.service;

import com.ecoleit.linkedin.profile.entity.Education;
import com.ecoleit.linkedin.profile.entity.Profile;
import com.ecoleit.linkedin.profile.modele.EducationDTO;
import com.ecoleit.linkedin.profile.repository.EducationRepository;
import com.ecoleit.linkedin.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final ProfileRepository profileRepository;

    public EducationService(EducationRepository educationRepository, ProfileRepository profileRepository) {
        this.educationRepository = educationRepository;
        this.profileRepository = profileRepository;
    }


    public EducationDTO convertToEducationDTO(Education education){
        return  new EducationDTO(
                education.getId(),
                education.getSchool(),
                education.getDegree(),
                education.getFiledOfStudy(),
                education.getStartDate(),
                education.getEndDate());
    }

    public List<EducationDTO> getEducationList(){
        return educationRepository
                .findAll()
                .stream()
                .map(this::convertToEducationDTO)
                .toList();
    }

    public List<EducationDTO> getEducationListByUserId(Integer userId){
        Profile profile = CommonService.getProfileByUserId(userId);
        return profile.getEducations()
                .stream()
                .map(this::convertToEducationDTO)
                .toList();
    }
    public EducationDTO createEducation(Integer userId, EducationDTO educationDTO){
        Profile profile = CommonService.getProfileByUserId(userId);
        Education newEducation = new Education();
        newEducation.setSchool(educationDTO.school());
        newEducation.setDegree(educationDTO.degree());
        newEducation.setFiledOfStudy(educationDTO.filedOfStudy());
        newEducation.setStartDate(educationDTO.startDate());
        newEducation.setEndDate(educationDTO.endDate());
        newEducation.setProfile(profile);
        educationRepository.save(newEducation);
        profile.getEducations().add(newEducation);
        profileRepository.save(profile);
        return convertToEducationDTO(newEducation);
    }

    public EducationDTO updateEducation(Integer userId,
                                          Integer educationId,
                                          EducationDTO educationDTO){
        Profile profile = CommonService.getProfileByUserId(userId);
        Education education = profile
                .getEducations()
                .stream()
                .filter(edu -> edu.getId()==educationId)
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Education not found"));
        education.setSchool(educationDTO.school());
        education.setDegree(educationDTO.degree());
        education.setFiledOfStudy(educationDTO.filedOfStudy());
        education.setStartDate(educationDTO.startDate());
        education.setEndDate(educationDTO.endDate());
        educationRepository.save(education);
        return convertToEducationDTO(education);
    }

    public void deleteEducation(Integer userId, Integer educationId) {
        if (!educationRepository.existsById(educationId)){
            throw new IllegalArgumentException("Education not found");
        }
        Profile profile = CommonService.getProfileByUserId(userId);
        profile.getEducations()
                        .removeIf(edu -> edu.getId()==educationId);
        educationRepository.deleteById(educationId);
        profileRepository.save(profile);
    }
}
