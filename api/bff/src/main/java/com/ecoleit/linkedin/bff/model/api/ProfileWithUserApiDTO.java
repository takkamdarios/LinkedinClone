package com.ecoleit.linkedin.bff.model.api;

import com.ecoleit.linkedin.bff.model.UserDTO;

public record ProfileWithUserApiDTO(Integer id, UserDTO user, String currentJobTitle, String industry, String summary,
                                    String headline, String website, Integer openForWork) {
}
