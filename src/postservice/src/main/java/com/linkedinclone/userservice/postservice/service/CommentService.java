package com.linkedinclone.userservice.postservice.service;

import com.linkedinclone.userservice.postservice.dto.CommentDTO;
import com.linkedinclone.userservice.postservice.model.Comment;
import com.linkedinclone.userservice.postservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = convertToEntity(commentDTO);
        Comment savedComment = commentRepository.save(comment);
        return convertToDto(savedComment);
    }

    public Optional<CommentDTO> getCommentById(Integer id) {
        return commentRepository.findById(id).map(this::convertToDto);
    }

    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<CommentDTO> updateComment(Integer id, CommentDTO commentDTO) {
        return commentRepository.findById(id).map(comment -> {
            comment.setContent(commentDTO.getContent());
            // Update other fields if necessary
            return convertToDto(commentRepository.save(comment));
        });
    }

    public boolean deleteComment(Integer id) {
        if(commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private CommentDTO convertToDto(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId().longValue());
        dto.setPostId(comment.getPostId().longValue());
        dto.setUserId(comment.getUserId().longValue());
        dto.setContent(comment.getContent());
        dto.setCreationDate(comment.getCreationDate());
        return dto;
    }

    private Comment convertToEntity(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId().intValue());
        comment.setPostId(dto.getPostId().intValue());
        comment.setUserId(dto.getUserId().intValue());
        comment.setContent(dto.getContent());
        comment.setParentCommentId(dto.getParentCommentId() != null ? dto.getParentCommentId().intValue() : null);
        comment.setCreationDate(dto.getCreationDate());
        return comment;
    }


}
