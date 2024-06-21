package com.ecoleit.linkedin.profile.controller;

import com.ecoleit.linkedin.profile.modele.SkillDTO;
import com.ecoleit.linkedin.profile.service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("")
    List<SkillDTO> getSkillList(){
        return skillService.getSkillList();
    }
}