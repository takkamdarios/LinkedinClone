package com.ecoleit.linkedin.profile.service;

import com.ecoleit.linkedin.profile.entity.Profile;
import com.ecoleit.linkedin.profile.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    private static ProfileRepository profileRepository;

    public CommonService(ProfileRepository profileRepository) {
        CommonService.profileRepository = profileRepository;
    }

    static Profile getProfileByUserId(Integer userId){
        return profileRepository
                .findByUserId(userId)
                .orElseThrow(()->
                        new IllegalArgumentException("Profile not found"));
    }
}
