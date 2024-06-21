package com.ecoleit.linkedin.bff.model.api;

public record ProfileApiDTO(Integer id, Integer userId, String currentJobTitle,
                            String industry, String summary, String headline, String website,
                            Integer openForWork) {
}
