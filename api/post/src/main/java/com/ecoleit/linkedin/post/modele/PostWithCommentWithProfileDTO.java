package com.ecoleit.linkedin.post.modele;

import java.sql.Timestamp;
import java.util.List;

public record PostWithCommentWithProfileDTO(Integer id, ProfileDTO profile, String title,
                                            String content, Timestamp creationDate, List<CommentWithProfileDTO> comments) {
}
