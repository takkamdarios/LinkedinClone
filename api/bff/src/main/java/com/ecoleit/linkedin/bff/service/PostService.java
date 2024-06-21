package com.ecoleit.linkedin.bff.service;

import com.ecoleit.linkedin.bff.config.ConfigProperties;
import com.ecoleit.linkedin.bff.model.PostWithProfileDTO;
import com.ecoleit.linkedin.bff.model.api.PostApiDTO;
import com.ecoleit.linkedin.bff.model.api.PostWithCommentApiDTO;
import com.ecoleit.linkedin.bff.model.api.PostWithProfileApiDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {
    private final RestClient restClient;
    private final ConfigProperties configProperties;

    public PostService(RestClient restClient, ConfigProperties configProperties) {
        this.restClient = restClient;
        this.configProperties = configProperties;
    }

    private  String getPostHost() {
        return "http://"
                + configProperties
                .getPostHost()
                + ":8083/posts";
    }

    public PostWithProfileApiDTO[] getPostList(){
        return  restClient
                .get()
                .uri(getPostHost())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(PostWithProfileApiDTO[].class);
    }

    public PostWithProfileApiDTO[] getPostByProfileId(Integer profileId){
        return  restClient
                .get()
                .uri(getPostHost()+"/profile/{profileId}", profileId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(PostWithProfileApiDTO[].class);
    }

    public PostWithCommentApiDTO getPostWithCommentById(Integer postId) {
        try{
            PostWithCommentApiDTO post = restClient
                    .get()
                    .uri(getPostHost() +"/{postId}/with-comments", postId)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(PostWithCommentApiDTO.class);
            if (post != null) {
                return new PostWithCommentApiDTO(
                        post.id(),
                        post.profile(),
                        post.title(),
                        post.content(),
                        post.creationDate(),
                        post.comments());
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }



    public PostWithProfileDTO addPost(PostApiDTO postApiDTO) {
        try {
            PostWithProfileApiDTO post = restClient
                    .post()
                    .uri(getPostHost())
                    .accept(MediaType.APPLICATION_JSON)
                    .body(postApiDTO)
                    .retrieve()
                    .body(PostWithProfileApiDTO.class);
            if (post != null) {
                return new PostWithProfileDTO(
                        post.id(),
                        post.profile(),
                        post.title(),
                        post.content(),
                        post.creationDate());
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public PostWithProfileDTO editPost(Integer postId,PostApiDTO postApiDTO) {
        try{
            PostWithProfileApiDTO post = restClient
                    .put()
                    .uri(getPostHost() +"/{postId}", postId)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(postApiDTO)
                    .retrieve()
                    .body(PostWithProfileApiDTO.class);
            if (post != null) {
                return new PostWithProfileDTO(
                        post.id(),
                        post.profile(),
                        post.title(),
                        post.content(),
                        post.creationDate());
            } else {
                return null;
            }
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public boolean deletePost(Integer postId) {
        try{
            restClient
                    .delete()
                    .uri(getPostHost() +"/{postId}", postId)
                    .retrieve();
            return true;
        }catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

}
