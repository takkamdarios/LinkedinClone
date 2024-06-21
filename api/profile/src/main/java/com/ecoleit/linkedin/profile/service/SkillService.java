package com.ecoleit.linkedin.profile.service;

import com.ecoleit.linkedin.profile.entity.Profile;
import com.ecoleit.linkedin.profile.entity.Skill;
import com.ecoleit.linkedin.profile.modele.SkillDTO;
import com.ecoleit.linkedin.profile.repository.ProfileRepository;
import com.ecoleit.linkedin.profile.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;
    private final ProfileRepository profileRepository;

    public SkillService(SkillRepository skillRepository, ProfileRepository profileRepository) {
        this.skillRepository = skillRepository;
        this.profileRepository = profileRepository;
    }

    public SkillDTO convertToSkillDTO(Skill skill){
        return new SkillDTO(
                skill.getId(),
                skill.getName()
        );
    }

    public List<SkillDTO> getSkillList(){
        return skillRepository
                .findAll()
                .stream()
                .map(this::convertToSkillDTO)
                .toList();
    }

    public List<SkillDTO> getSkillListByUserId(Integer userId){
        Profile profile = CommonService.getProfileByUserId(userId);
        return profile.getSkills()
                .stream()
                .map(this::convertToSkillDTO)
                .toList();
    }

    @Transactional
    public SkillDTO createSkill(Integer userId, SkillDTO skillDTO){
        Profile profile = CommonService.getProfileByUserId(userId);
        Skill newSkill = new Skill();
        newSkill.setName(skillDTO.name());
        Skill savedSkill = skillRepository.save(newSkill);
        profile.getSkills().add(savedSkill);
        profileRepository.save(profile);
        return convertToSkillDTO(newSkill);

    }

    @Transactional
    public SkillDTO updateSkill(
            Integer userId,
            Integer skillId,
            SkillDTO skillDTO) {
        Profile profile = CommonService.getProfileByUserId(userId);
        Skill skillToUpdate = profile.getSkills().stream()
                .filter(skill -> skill.getId()==skillId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Skill not found"));
        skillToUpdate.setName(skillDTO.name());
        skillRepository.save(skillToUpdate);
        return convertToSkillDTO(skillToUpdate);
    }

    @Transactional
    public void deleteSkill(Integer userId, Integer skillId){
        if (!skillRepository.existsById(skillId)){
            throw new IllegalArgumentException("Skill not found");
        }
        Profile profile = CommonService.getProfileByUserId(userId);
        Skill skill = skillRepository
                .findById(skillId)
                .orElse(null);
        profile.getSkills().remove(skill);
        profileRepository.save(profile);
    }

}
