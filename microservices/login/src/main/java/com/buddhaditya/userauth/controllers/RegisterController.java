package com.buddhaditya.userauth.controllers;

import com.buddhaditya.userauth.entities.User;
import com.buddhaditya.userauth.entities.request.RegisterRequestDTO;
import com.buddhaditya.userauth.entities.response.RegisterResponseDTO;
import com.buddhaditya.userauth.services.user.UserService;
import com.buddhaditya.userauth.utils.LoggerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/register")
public class RegisterController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    public RegisterController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO requestDTO) {
        try {
            // Convert RegisterRequestDTO to User using ObjectMapper
            User user = objectMapper.convertValue(requestDTO, User.class);

            // Register user
            RegisterResponseDTO registeredUser = userService.registerUser(user);

            LoggerUtil.info("New user registered: " + registeredUser.getUsername());

            // Map User to RegisterResponseDTO dynamically
            RegisterResponseDTO responseDTO = objectMapper.convertValue(registeredUser, RegisterResponseDTO.class);
            responseDTO.setMessage("User registered successfully");

            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            LoggerUtil.error("Error during registration: " + e.getMessage());
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }
}
