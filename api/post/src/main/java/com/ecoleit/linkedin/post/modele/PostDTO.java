package com.ecoleit.linkedin.post.modele;

import java.sql.Timestamp;

public record PostDTO(Integer id, Integer profileId,
                      String title, String content, Timestamp creationDate) {
}
