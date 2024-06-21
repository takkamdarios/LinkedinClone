package com.ecoleit.linkedin.profile.controller;

import com.ecoleit.linkedin.profile.modele.EducationDTO;
import com.ecoleit.linkedin.profile.service.EducationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController {
    private final EducationService educationService;


    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("")
    List<EducationDTO> getEducationList(){
        return educationService.getEducationList();
    }
}
