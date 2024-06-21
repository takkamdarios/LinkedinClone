
package com.ecoleit.linkedin.profile.modele;

public record ProfileDTO(Integer id, Integer userId, String username, String firstName,
                         String lastName, String currentJobTitle, String industry, String summary,
                         String headline, String website, Integer openForWork) {
}