package com.ecoleit.linkedin.post.controller;

import com.ecoleit.linkedin.post.modele.CommentDTO;
import com.ecoleit.linkedin.post.modele.CommentWithProfileDTO;
import com.ecoleit.linkedin.post.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    List<CommentWithProfileDTO> getCommentList(){
        return commentService.getCommentList();
    }

    @PostMapping("/{postId}")
    CommentWithProfileDTO createComment(@PathVariable Integer postId, @RequestBody CommentDTO commentDTO) {
        return commentService.createComment(postId, commentDTO);
    }

    @PutMapping("/{commentId}")
    CommentWithProfileDTO updateComment(@PathVariable Integer commentId, @RequestBody CommentWithProfileDTO commentWithProfileDTO) {
        return commentService.updateComment(commentId, commentWithProfileDTO);
    }

    @DeleteMapping("/{commentId}")
    ResponseEntity<String>deleteComment(@PathVariable Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted");
    }
}
