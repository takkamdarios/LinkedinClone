package com.ecoleit.linkedin.post.modele;

import java.sql.Timestamp;

public record CommentDTO(Integer id, Integer profileId, String content, Timestamp creationDate) {
}
