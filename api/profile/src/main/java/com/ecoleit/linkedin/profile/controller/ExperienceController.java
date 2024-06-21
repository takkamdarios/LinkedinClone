package com.ecoleit.linkedin.profile.controller;

import com.ecoleit.linkedin.profile.modele.ExperienceDTO;
import com.ecoleit.linkedin.profile.service.ExperienceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("")
    List<ExperienceDTO> getExperienceList(){
        return experienceService.getExperienceList();
    }
}
