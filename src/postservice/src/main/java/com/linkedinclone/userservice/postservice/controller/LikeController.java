package com.linkedinclone.userservice.postservice.controller;

import com.linkedinclone.userservice.postservice.dto.LikeDTO;
import com.linkedinclone.userservice.postservice.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<LikeDTO> addLike(@RequestBody LikeDTO likeDTO) {
        LikeDTO createdLike = likeService.createLike(likeDTO);
        return new ResponseEntity<>(createdLike, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikeDTO> getLikeById(@PathVariable Long id) {
        return likeService.getLikeById(id.intValue())
                .map(like -> new ResponseEntity<>(like, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<LikeDTO>> getAllLikes() {
        List<LikeDTO> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        likeService.deleteLike(id.intValue());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
