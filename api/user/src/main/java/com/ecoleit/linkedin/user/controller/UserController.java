package com.ecoleit.linkedin.user.controller;

import com.ecoleit.linkedin.user.auth.AuthenticationRequest;
import com.ecoleit.linkedin.user.model.UserDTO;
import com.ecoleit.linkedin.user.service.JwtService;
import com.ecoleit.linkedin.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8081/users

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @GetMapping("")
    List<UserDTO> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/{userId}")
    UserDTO getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }


    @GetMapping("/search/{username}")
    List<UserDTO> searchUserByUsername(@PathVariable String username) {
        return userService.searchUserByUsername(username);
    }

    @PostMapping("/register")
    UserDTO createNewUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PutMapping("/{userId}")
    UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Integer userId) {
        return userService.updateUser(userId, userDTO);
    }

    /*@PostMapping("/authenticate")
    public ResponseEntity<AuthenticationRequest> authenticate(
            @RequestBody AuthenticationRequest request
    ) {

    }*/
}

