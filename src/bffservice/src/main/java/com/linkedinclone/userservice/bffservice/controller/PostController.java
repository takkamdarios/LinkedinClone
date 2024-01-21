package com.linkedinclone.userservice.bffservice.controller;

import com.linkedinclone.userservice.bffservice.dto.PostDTO;
import com.linkedinclone.userservice.bffservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;




    // Get all posts
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get a single post by ID
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long postId) {
        PostDTO post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }

    // Create a new post
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto) {
        PostDTO newPost = postService.createPost(postDto);
        return ResponseEntity.ok(newPost);
    }

    // Update an existing post
    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO postDto) {
        PostDTO updatedPost = postService.updatePost(postId, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    // Delete a post
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    // Additional endpoints and methods as required...
}
