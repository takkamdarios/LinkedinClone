package com.ecoleit.linkedin.bff.model;

import java.sql.Timestamp;

public record CommentDTO (Integer id, Integer profileId, String content, Timestamp creationDate){
}
