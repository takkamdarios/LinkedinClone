package com.ecoleit.linkedin.bff.controller;

import com.ecoleit.linkedin.bff.model.CommentWithProfileDTO;
import com.ecoleit.linkedin.bff.model.PostWithProfileDTO;
import com.ecoleit.linkedin.bff.model.api.CommentApiDTO;
import com.ecoleit.linkedin.bff.model.api.PostApiDTO;
import com.ecoleit.linkedin.bff.model.api.PostWithCommentApiDTO;
import com.ecoleit.linkedin.bff.model.api.PostWithProfileApiDTO;
import com.ecoleit.linkedin.bff.service.CommentService;
import com.ecoleit.linkedin.bff.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api

@RestController
@RequestMapping("/api/posts")
public class PostBffController {
    private final PostService postService;
    private final CommentService commentService;

    public PostBffController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("")
    public PostWithProfileApiDTO[] getPostList() {
        return  postService.getPostList();
    }

    @GetMapping("/{postId}/with-comments")
    public PostWithCommentApiDTO getPostById(@PathVariable Integer postId) {
       return  postService.getPostWithCommentById(postId);
    }

    @GetMapping("/profile/{postId}")
    public PostWithProfileApiDTO[] getPostByProfileId(@PathVariable Integer postId) {
        return  postService.getPostByProfileId(postId);
    }

    @PostMapping("")
    public PostWithProfileDTO addPost(@RequestBody PostApiDTO postApiDTO) {
        return postService.addPost(postApiDTO);
    }

    @PutMapping("/{postId}")
    public PostWithProfileDTO editPost(@PathVariable Integer postId,@RequestBody PostApiDTO postApiDTO) {
        return postService.editPost(postId, postApiDTO);
    }

    @DeleteMapping("/{postId}")
    ResponseEntity<String> deletePost(@PathVariable Integer postId) {
        if(postService.deletePost(postId)){
            return ResponseEntity.ok("Post deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{postId}/comments")
    public CommentWithProfileDTO addComment(@PathVariable Integer postId, @RequestBody CommentApiDTO commentApiDTO) {
        return commentService.addComment(postId, commentApiDTO);
    }

    @PutMapping("/comments/{commentId}")
    public CommentWithProfileDTO EditComment(@PathVariable Integer commentId, @RequestBody CommentApiDTO commentApiDTO) {
        return commentService.EditComment(commentId, commentApiDTO);
    }

    @DeleteMapping("/comments/{commentId}")
    ResponseEntity<String> deleteComment(@PathVariable Integer commentId) {
        if(commentService.deleteComment(commentId)){
            return ResponseEntity.ok("Comment deleted");
        }
        return ResponseEntity.notFound().build();
    }

}
