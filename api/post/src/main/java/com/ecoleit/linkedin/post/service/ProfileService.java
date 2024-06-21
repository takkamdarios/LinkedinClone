package com.ecoleit.linkedin.post.service;

import com.ecoleit.linkedin.post.config.ConfigProperties;
import com.ecoleit.linkedin.post.modele.ProfileDTO;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Service
public class ProfileService {
    private final RestClient restClient;
    private final ConfigProperties configProperties;

    public ProfileService(RestClient restClient, ConfigProperties configProperties) {
        this.restClient = restClient;
        this.configProperties = configProperties;
    }

    private  String getProfileHost() {
        return "http://"
                + configProperties
                .getProfileHost()
                + ":8082/profiles";
    }

    public ProfileDTO getProfileById(Integer profileId){
        try {
            ProfileDTO profile = restClient
                    .get()
                    .uri(getProfileHost()+"/{profileId}", profileId)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(ProfileDTO.class);
            if (profile != null) {
                return new ProfileDTO(
                        profile.id(),
                        profile.user(),
                        profile.currentJobTitle(),
                        profile.industry(),
                        profile.summary(),
                        profile.headline(),
                        profile.website(),
                        profile.openForWork()
                );
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
