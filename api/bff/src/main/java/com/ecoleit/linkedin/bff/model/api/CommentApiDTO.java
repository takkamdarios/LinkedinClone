package com.ecoleit.linkedin.bff.model.api;

import java.sql.Timestamp;

public record CommentApiDTO(Integer id, Integer profileId, String content, Timestamp creationDate) {
}
