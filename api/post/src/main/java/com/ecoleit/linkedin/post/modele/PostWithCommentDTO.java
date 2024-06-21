package com.ecoleit.linkedin.post.modele;

import java.sql.Timestamp;
import java.util.List;

public record PostWithCommentDTO(Integer id, Integer profileId, String title,
                                 String content, Timestamp creationDate, List<CommentWithProfileDTO> comments) {
}
