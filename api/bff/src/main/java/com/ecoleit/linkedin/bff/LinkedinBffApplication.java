package com.ecoleit.linkedin.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class LinkedinBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkedinBffApplication.class, args);
    }

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .requestFactory(new JdkClientHttpRequestFactory())
                .build();
    }

}
