package com.ecoleit.linkedin.bff.model;

public record ProfileWithUserDTO(Integer id, UserDTO user, String currentJobTitle, String industry, String summary,
                                 String headline, String website, Integer openForWork) {
}
