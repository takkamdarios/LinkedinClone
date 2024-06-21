package com.ecoleit.linkedin.post.modele;

public record ProfileDTO(Integer id, UserDTO user, String currentJobTitle, String industry, String summary,
                         String headline, String website, Integer openForWork) {
}
