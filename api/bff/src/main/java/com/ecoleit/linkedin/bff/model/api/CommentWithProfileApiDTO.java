package com.ecoleit.linkedin.bff.model.api;

import com.ecoleit.linkedin.bff.model.ProfileDTO;
import com.ecoleit.linkedin.bff.model.ProfileWithUserDTO;

import java.sql.Timestamp;

public record CommentWithProfileApiDTO(Integer id, ProfileWithUserDTO profile, String content, Timestamp creationDate) {
}
