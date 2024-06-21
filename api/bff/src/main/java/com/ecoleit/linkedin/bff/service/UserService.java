package com.ecoleit.linkedin.bff.service;

import com.ecoleit.linkedin.bff.config.ConfigProperties;
import com.ecoleit.linkedin.bff.model.UserDTO;
import com.ecoleit.linkedin.bff.model.api.UserApiDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.List;

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

    public  UserDTO getUserById(Integer userId) {
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

    public List<UserDTO> getUserList(String username) {
        UserDTO[] users = restClient
                .get()
                .uri(getUserHost()+"/search/{username}", username)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(UserDTO[].class);
        assert users != null;
        return Arrays.stream(users)
                .map(user ->
                        new UserDTO(
                                user.id(),
                                user.username(),
                                user.firstName(),
                                user.lastName(),
                                user.email(),
                                user.birthDate(),
                                user.registrationDate(),
                                user.lastLoginDate()))
                .toList();
    }

    public UserDTO createNewUser(UserApiDTO userApiDTO) {
        try{
            UserApiDTO newUser = restClient
                    .post()
                    .uri(getUserHost()+"/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userApiDTO)
                    .retrieve()
                    .body(UserApiDTO.class);

            if (newUser != null) {
                return new UserDTO(
                        newUser.id(),
                        newUser.username(),
                        newUser.firstName(),
                        newUser.lastName(),
                        newUser.email(),
                        newUser.birthDate(),
                        newUser.registrationDate(),
                        newUser.lastLoginDate()
                );
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public UserDTO updateUser(UserDTO userApiDTO, Integer userId) {
        try{
            UserDTO newUser = restClient
                    .put()
                    .uri(getUserHost()+"/{userId}", userId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userApiDTO)
                    .retrieve()
                    .body(UserDTO.class);

            if (newUser != null) {
                return new UserDTO(
                        newUser.id(),
                        newUser.username(),
                        newUser.firstName(),
                        newUser.lastName(),
                        newUser.email(),
                        newUser.birthDate(),
                        newUser.registrationDate(),
                        newUser.lastLoginDate()
                );
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

}
