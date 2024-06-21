package com.ecoleit.linkedin.bff.service;

import com.ecoleit.linkedin.bff.config.ConfigProperties;
import com.ecoleit.linkedin.bff.model.CommentWithProfileDTO;
import com.ecoleit.linkedin.bff.model.api.CommentApiDTO;
import com.ecoleit.linkedin.bff.model.api.CommentWithProfileApiDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CommentService {
    private final RestClient restClient;
    private final ConfigProperties configProperties;

    public CommentService(RestClient restClient, ConfigProperties configProperties) {
        this.restClient = restClient;
        this.configProperties = configProperties;
    }

    private  String getCommentHost() {
        return "http://"
                + configProperties
                .getPostHost()
                + ":8083/comments";
    }

    public CommentWithProfileDTO addComment(Integer postId, CommentApiDTO commentApiDTO) {
        try{
            CommentWithProfileApiDTO newComment = restClient
                    .post()
                    .uri(getCommentHost() +"/{postId}", postId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(commentApiDTO)
                    .retrieve()
                    .body(CommentWithProfileApiDTO.class);

            if (newComment != null) {
                return new CommentWithProfileDTO(
                        newComment.id(),
                        newComment.profile(),
                        newComment.content(),
                        newComment.creationDate());
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public CommentWithProfileDTO EditComment( Integer commentId, CommentApiDTO commentApiDTO) {
        try{
            CommentWithProfileApiDTO newComment = restClient
                    .put()
                    .uri(getCommentHost() +"/{commentId}", commentId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(commentApiDTO)
                    .retrieve()
                    .body(CommentWithProfileApiDTO.class);

            if (newComment != null) {
                return new CommentWithProfileDTO(
                        newComment.id(),
                       newComment.profile(),
                        newComment.content(),
                        newComment.creationDate());
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public boolean  deleteComment(Integer commentId) {
        try{
            restClient
                    .delete()
                    .uri(getCommentHost() +"/{commentId}", commentId)
                    .retrieve();
            return true;
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

}
