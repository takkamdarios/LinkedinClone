package com.ecoleit.linkedin.bff.model;

import java.sql.Timestamp;

public record CommentWithProfileDTO(Integer id, ProfileWithUserDTO profile, String content, Timestamp creationDate) {
}
