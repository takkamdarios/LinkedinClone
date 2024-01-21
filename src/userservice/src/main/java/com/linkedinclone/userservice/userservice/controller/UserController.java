package com.linkedinclone.userservice.userservice.controller;

import com.linkedinclone.userservice.userservice.dto.UserDTO;
import com.linkedinclone.userservice.userservice.dto.UserLoginDTO;
import com.linkedinclone.userservice.userservice.dto.UserRegistrationDTO;
import com.linkedinclone.userservice.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@Tag(name = "User", description = "Operations related to user management in the system.")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(
            summary = "Register User",
            description = "Enroll a new user into the system with the necessary details.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User registered successfully."),
                    @ApiResponse(responseCode = "400", description = "Invalid user data provided.")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Registration details for enrolling a new user.", content = @Content(schema = @Schema(implementation = UserRegistrationDTO.class)))  @RequestBody UserRegistrationDTO registrationDTO) {
        try {
            UserDTO newUser = userService.registerUser(registrationDTO);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



    @Operation(summary = "User Login", description = "Authenticate a user's credentials and log them into the system.")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO loginDTO) {
        try {
            UserDTO userDTO = userService.loginUser(loginDTO);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @Operation(summary = "Retrieve User", description = "Fetch a user's details using their unique identifier.")
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@Parameter(description = "The unique identifier of the user to be retrieved.") @PathVariable Long id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return ResponseEntity.ok(userDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Update User", description = "Modify a user's details by their unique identifier.")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            UserDTO updatedUser = userService.updateUser(id, userDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @Operation(summary = "Delete User", description = "Remove a user from the system by their unique identifier.")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
