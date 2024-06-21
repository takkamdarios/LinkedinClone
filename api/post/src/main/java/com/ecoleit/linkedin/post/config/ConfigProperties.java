package com.ecoleit.linkedin.post.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "linkedin")
public class ConfigProperties {
    private String profileHost;

    public String getProfileHost() {
        return profileHost;
    }

    public void setProfileHost(String profileHost) {
        this.profileHost = profileHost;
    }
}
