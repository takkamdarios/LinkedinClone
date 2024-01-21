package com.linkedinclone.userservice.userservice.service;

import com.linkedinclone.userservice.userservice.dto.UserDTO;
import com.linkedinclone.userservice.userservice.dto.UserLoginDTO;
import com.linkedinclone.userservice.userservice.dto.UserRegistrationDTO;

public interface UserService {

    UserDTO registerUser(UserRegistrationDTO registrationDTO) throws Exception;

    UserDTO loginUser(UserLoginDTO loginDTO) throws Exception;

    UserDTO getUserById(Long id) throws Exception;

    UserDTO updateUser(Long id, UserDTO userDTO) throws Exception;

    void deleteUser(Long id) throws Exception;
}
