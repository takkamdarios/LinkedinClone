package com.ecoleit.linkedin.post.service;

import com.ecoleit.linkedin.post.entity.Comment;
import com.ecoleit.linkedin.post.entity.Post;
import com.ecoleit.linkedin.post.modele.CommentDTO;
import com.ecoleit.linkedin.post.modele.CommentWithProfileDTO;
import com.ecoleit.linkedin.post.repository.CommentRepository;
import com.ecoleit.linkedin.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private  final PostRepository postRepository;
    private final ProfileService profileService;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, ProfileService profileService) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.profileService = profileService;
    }

    public List<CommentWithProfileDTO> getCommentList(){
        return commentRepository
                .findAll()
                .stream()
                .map(comment ->
                        new CommentWithProfileDTO(
                                comment.getId(),
                                profileService.getProfileById(comment.getProfileId()),
                                comment.getContent(),
                                comment.getCreationDate()))
                .toList();
    }

    public CommentWithProfileDTO createComment(Integer postId, CommentDTO commentDTO) {
        Optional<Post> optionalPost = postRepository.findById(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            // Create a new comment and associate it with the post
            Comment newComment = new Comment();
            newComment.setPost(post); // Set the post for the comment
            newComment.setProfileId(commentDTO.profileId());
            newComment.setContent(commentDTO.content());
            newComment.setCreationDate(new Timestamp(System.currentTimeMillis()));

            Comment savedComment = commentRepository.save(newComment);

            return new CommentWithProfileDTO(
                    savedComment.getId(),
                    profileService.getProfileById(savedComment.getProfileId()),
                    savedComment.getContent(),
                    savedComment.getCreationDate()
            );
        } else {
            // Handle case where the specified post doesn't exist
            throw new IllegalArgumentException("Post not found with id: " + postId);
        }
    }

    public CommentWithProfileDTO updateComment(Integer commentId, CommentWithProfileDTO commentWithProfileDTO) {
        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        if (optionalComment.isPresent()) {
            Comment existingComment = optionalComment.get();
            existingComment.setContent(commentWithProfileDTO.content());

            Comment updatedComment = commentRepository.save(existingComment);

            return new CommentWithProfileDTO(
                    updatedComment.getId(),
                    profileService.getProfileById(updatedComment.getProfileId()),
                    updatedComment.getContent(),
                    updatedComment.getCreationDate()
            );
        } else {
            throw new RuntimeException("Comment not found with id: " + commentId);
        }
    }

    public void deleteComment(Integer commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<CommentWithProfileDTO> getCommentsByPostId(Integer postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(comment ->
                        new CommentWithProfileDTO(
                                comment.getId(),
                                profileService.getProfileById(comment.getProfileId()),
                                comment.getContent(),
                                comment.getCreationDate()))
                .toList();
    }
}
