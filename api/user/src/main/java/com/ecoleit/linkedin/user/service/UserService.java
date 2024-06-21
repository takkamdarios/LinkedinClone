package com.ecoleit.linkedin.user.service;

import com.ecoleit.linkedin.user.entity.User;
import com.ecoleit.linkedin.user.model.UserDTO;
import com.ecoleit.linkedin.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    private int calculateAge(Date birth_date) {
        LocalDate dateNow = LocalDate.now();
        return Period.between(birth_date.toLocalDate(), dateNow).getYears();
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getBirthDate(),
                user.getRegistrationDate(),
                user.getLastLoginDate());
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUserList() {
        return userRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public UserDTO registerUser(UserDTO userDTO) {
        int age = calculateAge(userDTO.birthDate());
        User newUser = new User();

        if (userRepository.existsByUsername(userDTO.username())) {
            throw new IllegalArgumentException("Username already in use. Please choose a different one.");
        } else if (userRepository.existsByEmail(userDTO.email())) {
            throw new IllegalArgumentException("Email already in use. Please choose a different one.");
        } else if (age < 18) {
            throw new IllegalArgumentException("Users must be at least 18 years old to register.");
        } else {
            newUser.setUsername(userDTO.username());
            newUser.setEmail(userDTO.email());
            newUser.setFirstName(userDTO.firstName());
            newUser.setLastName(userDTO.lastName());
            newUser.setPassword(userDTO.password());
            newUser.setBirthDate(userDTO.birthDate());
            newUser.setRegistrationDate(LocalDateTime.now());
            newUser.setLastLoginDate(Timestamp.valueOf(LocalDateTime.now()));

            User savedUser = userRepository.save(newUser);
            //var jwtToken = jwtService.generateToken(savedUser);
            return convertToDTO(savedUser);

        }

    }

    public UserDTO updateUser(Integer userId, UserDTO updatedUserDTO) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (!existingUser.getUsername().equals(updatedUserDTO.username())
                && userRepository.existsByUsername(updatedUserDTO.username())) {
            throw new IllegalArgumentException("Username already in use. Please choose a different one.");
        }
        if (!existingUser.getEmail().equals(updatedUserDTO.email())
                && userRepository.existsByEmail(updatedUserDTO.email())) {
            throw new IllegalArgumentException("Email already in use. Please choose a different one.");
        }
        existingUser.setUsername(updatedUserDTO.username());
        existingUser.setEmail(updatedUserDTO.email());
        existingUser.setFirstName(updatedUserDTO.firstName());
        existingUser.setLastName(updatedUserDTO.lastName());
        existingUser.setBirthDate(updatedUserDTO.birthDate());
        User savedUser = userRepository.save(existingUser);
        return convertToDTO(savedUser);
    }

    public UserDTO getUserById(Integer userId) {
        return userRepository
                .findById(userId)
                .map(this::convertToDTO)
                .orElse(null);

    }


    public List<UserDTO> searchUserByUsername(String username) {
        return userRepository
                .findByUsernameContaining(username)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }


}
