package com.ecoleit.linkedin.bff.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "linkedin")
public class ConfigProperties {
    private String userHost;
    private String profileHost;
    private String postHost;

    public String getUserHost() {
        return userHost;
    }

    public void setUserHost(String userHost) {
        this.userHost = userHost;
    }

    public String getProfileHost() {
        return profileHost;
    }

    public void setProfileHost(String profileHost) {
        this.profileHost = profileHost;
    }

    public String getPostHost() {
        return postHost;
    }

    public void setPostHost(String postHost) {
        this.postHost = postHost;
    }
}
