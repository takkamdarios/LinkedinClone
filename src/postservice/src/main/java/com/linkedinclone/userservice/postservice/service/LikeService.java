package com.linkedinclone.userservice.postservice.service;

import com.linkedinclone.userservice.postservice.dto.LikeDTO;
import com.linkedinclone.userservice.postservice.model.Like;
import com.linkedinclone.userservice.postservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public LikeDTO createLike(LikeDTO likeDTO) {
        Like like = convertToEntity(likeDTO);
        like = likeRepository.save(like);
        return convertToDto(like);
    }

    public Optional<LikeDTO> getLikeById(Integer id) {
        return likeRepository.findById(id).map(this::convertToDto);
    }

    public List<LikeDTO> getAllLikes() {
        return likeRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public boolean deleteLike(Integer id) {
        if(likeRepository.existsById(id)) {
            likeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private LikeDTO convertToDto(Like like) {
        LikeDTO dto = new LikeDTO();
        dto.setId(like.getId());
        dto.setPostId(like.getPostId());
        dto.setUserId(like.getUserId());
        dto.setCreationDate(like.getCreationDate());
        return dto;
    }

    private Like convertToEntity(LikeDTO dto) {
        Like like = new Like();
        like.setId(dto.getId());
        like.setPostId(dto.getPostId());
        like.setUserId(dto.getUserId());
        like.setCreationDate(dto.getCreationDate() != null ? dto.getCreationDate() : LocalDateTime.now());
        return like;
    }


}
