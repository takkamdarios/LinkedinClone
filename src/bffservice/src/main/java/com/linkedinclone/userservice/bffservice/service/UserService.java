package com.linkedinclone.userservice.bffservice.service;

import com.linkedinclone.userservice.bffservice.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    private final String userServiceUrl = "http://localhost:8080/"; // URL of the User microservice

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO getUserById(Long userId) {
        // Retrieve a user by ID
        return restTemplate.getForObject(userServiceUrl + "/" + userId, UserDTO.class);
    }

    public UserDTO createUser(UserDTO userDto) {
        // Create a new user
        return restTemplate.postForObject(userServiceUrl, userDto, UserDTO.class);
    }

    public UserDTO updateUser(Long userId, UserDTO userDto) {
        // Update an existing user
        restTemplate.put(userServiceUrl + "/" + userId, userDto);
        return userDto;
    }

    public void deleteUser(Long userId) {
        // Delete a user
        restTemplate.delete(userServiceUrl + "/" + userId);
    }
}
