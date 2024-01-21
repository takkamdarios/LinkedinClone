package com.linkedinclone.userservice.postservice.service;

import com.linkedinclone.userservice.postservice.dto.PostDTO;
import com.linkedinclone.userservice.postservice.model.Post;
import com.linkedinclone.userservice.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDTO createPost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        Post savedPost = postRepository.save(post);
        return convertToDto(savedPost);
    }

    public Optional<PostDTO> getPostById(Integer id) {
        return postRepository.findById(id).map(this::convertToDto);
    }

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<PostDTO> updatePost(Integer id, PostDTO postDTO) {
        return postRepository.findById(id).map(existingPost -> {
            existingPost.setTitle(postDTO.getTitle());
            existingPost.setContent(postDTO.getContent());
            // Update other fields as necessary
            Post updatedPost = postRepository.save(existingPost);
            return convertToDto(updatedPost);
        });
    }

    public boolean deletePost(Integer id) {
        if(postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private PostDTO convertToDto(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId().longValue());
        dto.setProfileId(post.getUserId().longValue()); // Assuming userId matches with profileId
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setCreationDate(post.getCreationDate());
        return dto;
    }

    private Post convertToEntity(PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId() != null ? dto.getId().intValue() : null);
        post.setUserId(dto.getProfileId() != null ? dto.getProfileId().intValue() : null); // Assuming profileId matches with userId
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCreationDate(dto.getCreationDate() != null ? dto.getCreationDate() : LocalDateTime.now());
        return post;
    }
}
