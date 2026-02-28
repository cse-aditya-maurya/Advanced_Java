package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor Injection (Best Practice)
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ================= CREATE =================

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Later we encrypt
        user.setRole(Role.valueOf(request.getRole()));
        user.setAge(request.getAge());

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    // ================= GET ALL =================

    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ================= GET BY ID =================

    @Override
    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );

        return mapToResponse(user);
    }

    // ================= UPDATE =================

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO request) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setRole(Role.valueOf(request.getRole()));
        user.setAge(request.getAge());

        User updatedUser = userRepository.save(user);

        return mapToResponse(updatedUser);
    }

    // ================= DELETE =================

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id)
                );

        userRepository.delete(user);
    }

    // ================= MAPPER =================

    private UserResponseDTO mapToResponse(User user) {

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setAge(user.getAge());

        return response;
    }
}