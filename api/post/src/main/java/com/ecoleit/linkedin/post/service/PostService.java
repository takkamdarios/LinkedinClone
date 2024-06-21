package com.ecoleit.linkedin.post.service;

import com.ecoleit.linkedin.post.entity.Post;
import com.ecoleit.linkedin.post.modele.*;
import com.ecoleit.linkedin.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;
    private final ProfileService profileService;

    public PostService(PostRepository postRepository, CommentService commentService, ProfileService profileService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
        this.profileService = profileService;
    }
    private PostWithProfileDTO convertToPostDTO(Post post){
        ProfileDTO profileDTO = profileService.getProfileById(post.getProfileId());
        return new PostWithProfileDTO(
                post.getId(),
                profileDTO,
                post.getTitle(),
                post.getContent(),
                post.getCreationDate());
    }

    public List<PostWithProfileDTO> getPostList(){
        return postRepository
                .findAll()
                .stream()
                .map(this::convertToPostDTO)
                .toList();
    }

    public PostWithProfileDTO getPostById(Integer postId) {
        return postRepository.findById(postId)
                .map(this::convertToPostDTO)
                .orElse(null);
    }

    public PostWithProfileDTO createPost(PostDTO postDTO) {
        Post newPost = new Post();
        newPost.setProfileId(postDTO.profileId());
        newPost.setTitle(postDTO.title());
        newPost.setContent(postDTO.content());
        newPost.setCreationDate(new Timestamp(System.currentTimeMillis()));

        Post savedPost = postRepository.save(newPost);
        ProfileDTO profile = profileService.getProfileById(savedPost.getProfileId());
        return new PostWithProfileDTO(
                savedPost.getId(),
                profile,
                savedPost.getTitle(),
                savedPost.getContent(),
                savedPost.getCreationDate()
        );
    }

    public PostWithProfileDTO updatePost(Integer postId, PostDTO postDTO) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            existingPost.setTitle(postDTO.title());
            existingPost.setContent(postDTO.content());

            Post updatedPost = postRepository.save(existingPost);
            ProfileDTO profile = profileService.getProfileById(updatedPost.getProfileId());
            return new PostWithProfileDTO(
                    updatedPost.getId(),
                    profile,
                    updatedPost.getTitle(),
                    updatedPost.getContent(),
                    updatedPost.getCreationDate()
            );
        } else {
            throw new RuntimeException("Post not found with id: " + postId);
        }
    }

    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }



    public PostWithCommentWithProfileDTO getPostWithComments(Integer postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            List<CommentWithProfileDTO> comments =commentService.getCommentsByPostId(postId);
            ProfileDTO profile = profileService.getProfileById(post.getProfileId());
            return new PostWithCommentWithProfileDTO(
                    post.getId(),
                    profile,
                    post.getTitle(),
                    post.getContent(),
                    post.getCreationDate(),
                    comments
            );
        } else {
            throw new RuntimeException("Post not found with id");
        }
    }

    public List<PostWithProfileDTO> getPostByProfileId(Integer profileId){
                return postRepository
                        .findAllByProfileId(profileId)
                        .stream()
                        .map(this::convertToPostDTO)
                        .toList();
    }

}
