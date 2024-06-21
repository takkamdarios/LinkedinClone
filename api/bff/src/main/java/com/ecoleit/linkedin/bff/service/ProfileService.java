package com.ecoleit.linkedin.bff.service;

import com.ecoleit.linkedin.bff.config.ConfigProperties;
import com.ecoleit.linkedin.bff.model.FullProfileDTO;
import com.ecoleit.linkedin.bff.model.api.FullProfileApiDTO;
import com.ecoleit.linkedin.bff.model.api.ProfileApiDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;

@Service
public class ProfileService {
    private final RestClient restClient;
    private final ConfigProperties configProperties;
    private final UserService userService;

    public ProfileService(RestClient restClient, ConfigProperties configProperties, UserService userService) {
        this.restClient = restClient;
        this.configProperties = configProperties;
        this.userService = userService;
    }

    private  String getProfileUserHost() {
        return "http://"
                + configProperties
                .getProfileHost()
                + ":8082/profiles/user";
    }
    private  String getProfileHost() {
        return "http://"
                + configProperties
                .getProfileHost()
                + ":8082/profiles";
    }

    public FullProfileDTO getProfileByUserId(Integer userId) {
        try{
            FullProfileApiDTO fullProfileApiDTO = restClient
                    .get()
                    .uri(getProfileUserHost()+"/{userId}", userId)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(FullProfileApiDTO.class);
            if (fullProfileApiDTO != null) {
                return new FullProfileDTO(
                        fullProfileApiDTO.id(),
                        fullProfileApiDTO.user(),
                        fullProfileApiDTO.currentJobTitle(),
                        fullProfileApiDTO.industry(),
                        fullProfileApiDTO.summary(),
                        fullProfileApiDTO.headline(),
                        fullProfileApiDTO.website(),
                        fullProfileApiDTO.openForWork(),
                        fullProfileApiDTO.skills(),
                        fullProfileApiDTO.connections(),
                        fullProfileApiDTO.educations(),
                        fullProfileApiDTO.experiences());
            } else {
                return null;
            }
        }catch (Exception exception){
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public FullProfileDTO getProfileById(Integer profileId) {
        try{
            FullProfileApiDTO fullProfileApiDTO = restClient
                    .get()
                    .uri(getProfileHost()+"/{profileId}", profileId)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(FullProfileApiDTO.class);
            if (fullProfileApiDTO != null) {
                return new FullProfileDTO(
                        fullProfileApiDTO.id(),
                        fullProfileApiDTO.user(),
                        fullProfileApiDTO.currentJobTitle(),
                        fullProfileApiDTO.industry(),
                        fullProfileApiDTO.summary(),
                        fullProfileApiDTO.headline(),
                        fullProfileApiDTO.website(),
                        fullProfileApiDTO.openForWork(),
                        fullProfileApiDTO.skills(),
                        fullProfileApiDTO.connections(),
                        fullProfileApiDTO.educations(),
                        fullProfileApiDTO.experiences());
            } else {
                return null;
            }
        }catch (Exception exception){
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public FullProfileApiDTO createProfile(ProfileApiDTO profileApiDTO) {
        try{
            FullProfileApiDTO profile = restClient
                    .post()
                    .uri(getProfileHost())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(profileApiDTO)
                    .retrieve()
                    .body(FullProfileApiDTO.class);

            if (profile != null) {
                return new FullProfileApiDTO(
                        profile.id(),
                        profile.user(),
                        profile.currentJobTitle(),
                        profile.industry(),
                        profile.summary(),
                        profile.headline(),
                        profile.website(),
                        profile.openForWork(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        new ArrayList<>());
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public FullProfileApiDTO updateProfile(Integer userId, ProfileApiDTO profileApiDTO) {
        try{
            FullProfileApiDTO fullProfileApiDTO = restClient
                    .put()
                    .uri(getProfileUserHost()+"/{userId}", userId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(profileApiDTO)
                    .retrieve()
                    .body(FullProfileApiDTO.class);

            if (fullProfileApiDTO != null) {
                return new FullProfileApiDTO(
                        fullProfileApiDTO.id(),
                        fullProfileApiDTO.user(),
                        fullProfileApiDTO.currentJobTitle(),
                        fullProfileApiDTO.industry(),
                        fullProfileApiDTO.summary(),
                        fullProfileApiDTO.headline(),
                        fullProfileApiDTO.website(),
                        fullProfileApiDTO.openForWork(),
                        fullProfileApiDTO.skills(),
                        fullProfileApiDTO.connections(),
                        fullProfileApiDTO.educations(),
                        fullProfileApiDTO.experiences());
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public boolean deleteSkill(Integer userId,Integer skillId) {
        try{
            restClient
                    .delete()
                    .uri(getProfileUserHost()+"/{userId}/skills/{skillId}", userId, skillId)
                    .retrieve();
            return true;
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
    
}
