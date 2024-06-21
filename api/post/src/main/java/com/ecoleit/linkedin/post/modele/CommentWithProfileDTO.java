package com.ecoleit.linkedin.post.modele;

import java.sql.Timestamp;

public record CommentWithProfileDTO(Integer id, ProfileDTO profile, String content, Timestamp creationDate) {
}
