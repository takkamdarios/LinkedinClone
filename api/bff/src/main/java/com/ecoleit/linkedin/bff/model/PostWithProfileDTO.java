package com.ecoleit.linkedin.bff.model;

import java.sql.Timestamp;

public record PostWithProfileDTO(Integer id, ProfileDTO profile,
                                 String title, String content, Timestamp creationDate) {
}
