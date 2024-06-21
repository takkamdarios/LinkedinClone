package com.ecoleit.linkedin.profile.service;

import com.ecoleit.linkedin.profile.config.ConfigProperties;
import com.ecoleit.linkedin.profile.modele.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UserService {
    private final RestClient restClient;
    private final ConfigProperties configProperties;

    public UserService(RestClient restClient, ConfigProperties configProperties) {
        this.restClient = restClient;
        this.configProperties = configProperties;
    }

    private  String getUserHost() {
        return "http://"
                + configProperties
                .getUserHost()
                + ":8081/users";
    }

    public UserDTO getUserById(Integer userId) {
        try{
            UserDTO user = restClient
                    .get()
                    .uri(getUserHost()+"/{userId}", userId)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(UserDTO.class);
            if (user != null) {
                return new UserDTO(
                        user.id(),
                        user.username(),
                        user.firstName(),
                        user.lastName(),
                        user.email(),
                        user.birthDate(),
                        user.registrationDate(),
                        user.lastLoginDate()
                );
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
