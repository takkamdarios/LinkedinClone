package com.ecoleit.linkedin.bff.model.api;


import com.ecoleit.linkedin.bff.model.ProfileWithUserDTO;

import java.sql.Timestamp;
import java.util.List;

public record PostWithCommentApiDTO(Integer id, ProfileWithUserDTO profile, String title,
                                    String content, Timestamp creationDate, List<CommentWithProfileApiDTO> comments) {
}
