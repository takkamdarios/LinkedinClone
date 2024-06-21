package com.ecoleit.linkedin.profile.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "linkedin")
public class ConfigProperties {
    private String userHost;

    public String getUserHost() {
        return userHost;
    }

    public void setUserHost(String userHost) {
        this.userHost = userHost;
    }
}
