package com.ecoleit.linkedin.profile.controller;

import com.ecoleit.linkedin.profile.modele.ExperienceDTO;
import com.ecoleit.linkedin.profile.modele.ProfileDTO;
import com.ecoleit.linkedin.profile.service.ConnectionService;
import com.ecoleit.linkedin.profile.service.ExperienceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/connections")
public class ConnectionController {
    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @GetMapping("")
    List<ProfileDTO> getConnectionList(){
        return connectionService.getConnectionList();
    }
}
