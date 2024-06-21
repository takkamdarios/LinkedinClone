package com.ecoleit.linkedin.bff.controller;

import com.ecoleit.linkedin.bff.config.ConfigProperties;
import com.ecoleit.linkedin.bff.model.api.UserApiDTO;
import com.ecoleit.linkedin.bff.model.UserDTO;
import com.ecoleit.linkedin.bff.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;


//http://localhost:8080/api

@RestController
@RequestMapping("/api/users")
public class UserBffController {
    private final UserService userService;

    public UserBffController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/search/{username}")
    public List<UserDTO> getUserList(@PathVariable String username) {
        return  userService.getUserList(username);
    }

    @PostMapping("/register")
    public UserDTO createNewUser(@RequestBody UserApiDTO userApiDTO) {
        return  userService.createNewUser(userApiDTO);
    }

    @PutMapping("/{userId}")
    public UserDTO updateUser(@RequestBody UserDTO userApiDTO, @PathVariable Integer userId) {
        return userService.updateUser(userApiDTO, userId);
    }
}




