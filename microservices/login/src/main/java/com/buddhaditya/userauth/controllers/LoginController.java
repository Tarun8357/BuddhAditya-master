package com.buddhaditya.userauth.controllers;

import com.buddhaditya.userauth.entities.request.LoginRequestDTO;
import com.buddhaditya.userauth.entities.response.LoginResponseDTO;
import com.buddhaditya.userauth.jwtutils.JwtService;
import com.buddhaditya.userauth.utils.LoggerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // Constructor Injection
    public LoginController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                // Generate JWT token
                String token = jwtService.generateAccessToken(loginRequest.getUsername());

                LoggerUtil.info("User logged in successfully: " + loginRequest.getUsername());

                // Create response DTO
                LoginResponseDTO responseDTO = new LoginResponseDTO(loginRequest.getUsername(), token, Collections.singleton("Login successful"));

                return ResponseEntity.ok(responseDTO);
            } else {
                return ResponseEntity.status(401).body("Invalid username or password");
            }
        } catch (Exception e) {
            LoggerUtil.error("Login failed for user: " + loginRequest.getUsername() + " - " + e.getMessage());
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
