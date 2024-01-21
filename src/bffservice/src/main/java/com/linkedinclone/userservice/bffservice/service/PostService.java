package com.linkedinclone.userservice.bffservice.service;

import com.linkedinclone.userservice.bffservice.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;
    private final String postServiceUrl = "http://localhost:8078/"; // URL of the Post microservice

    @Autowired
    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PostDTO> getAllPosts() {
        // Assuming the post service returns an array of PostDTOs
        return Arrays.asList(restTemplate.getForObject(postServiceUrl, PostDTO[].class));
    }

    public PostDTO getPostById(Long postId) {
        // Retrieve a single post by ID
        return restTemplate.getForObject(postServiceUrl + "/" + postId, PostDTO.class);
    }

    public PostDTO createPost(PostDTO postDto) {
        // Create a new post
        return restTemplate.postForObject(postServiceUrl, postDto, PostDTO.class);
    }

    public PostDTO updatePost(Long postId, PostDTO postDto) {
        // Update an existing post
        restTemplate.put(postServiceUrl + "/" + postId, postDto);
        return postDto; // Assuming the post is updated correctly
    }

    public void deletePost(Long postId) {
        // Delete a post
        restTemplate.delete(postServiceUrl + "/" + postId);
    }
}
