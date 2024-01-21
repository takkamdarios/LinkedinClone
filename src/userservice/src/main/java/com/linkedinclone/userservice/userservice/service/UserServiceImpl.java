package com.linkedinclone.userservice.userservice.service;

import com.linkedinclone.userservice.userservice.dto.UserDTO;
import com.linkedinclone.userservice.userservice.dto.UserLoginDTO;
import com.linkedinclone.userservice.userservice.dto.UserRegistrationDTO;
import com.linkedinclone.userservice.userservice.model.User;
import com.linkedinclone.userservice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO registerUser(UserRegistrationDTO registrationDTO) {
        LocalDate birthDate = registrationDTO.getBirthDate();
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        if (age < 18) {
            throw new IllegalArgumentException("User must be at least 18 years old to register.");
        }

        if (userRepository.existsByUsername(registrationDTO.getUsername())) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        if (userRepository.existsByEmail(registrationDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setEmail(registrationDTO.getEmail());
        user.setBirthDate(birthDate);
        user.setAge(age);
        user.setRegistrationDate(LocalDate.now());
        user.setLastLoginDate(null);

        user = userRepository.save(user);

        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthDate(), user.getAge());
    }


    @Override
    public UserDTO loginUser(UserLoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        user.setLastLoginDate(LocalDate.now());
        userRepository.save(user);

        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthDate(), user.getAge());
    }


    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found."));
        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthDate(), user.getAge());
    }


    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found."));

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());


        user = userRepository.save(user);

        return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthDate(), user.getAge());
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found."));
        userRepository.delete(user);
    }
}
