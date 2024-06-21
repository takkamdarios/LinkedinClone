package com.ecoleit.linkedin.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class LinkedinPostApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkedinPostApplication.class, args);
    }

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .requestFactory(new JdkClientHttpRequestFactory())
                .build();
    }
}
