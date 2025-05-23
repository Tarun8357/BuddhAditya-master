package com.buddhaditya.userauth.services.user;

import com.buddhaditya.userauth.entities.Role;
import com.buddhaditya.userauth.entities.User;
import com.buddhaditya.userauth.entities.response.RegisterResponseDTO;
import com.buddhaditya.userauth.exceptions.RoleNotFoundException;
import com.buddhaditya.userauth.exceptions.UserAlreadyExistsException;
import com.buddhaditya.userauth.repository.interfaces.RoleRepository;
import com.buddhaditya.userauth.repository.interfaces.UserRepository;
import com.buddhaditya.userauth.utils.LoggerUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponseDTO registerUser(User user) {
        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            LoggerUtil.error("Registration failed: Username already taken - " + user.getUsername());
            throw new UserAlreadyExistsException("Username already taken");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            LoggerUtil.error("Registration failed: Email already registered - " + user.getEmail());
            throw new UserAlreadyExistsException("Email already registered");
        }

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Assign default role USER if no roles are provided
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            Role defaultRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> {
                        LoggerUtil.error("Error during registration: Default role USER not found");
                        return new RoleNotFoundException("Default role USER not found");
                    });

            Set<Role> roles = new HashSet<>();
            roles.add(defaultRole);
            user.setRoles(roles);
        }

        // Save user
        User savedUser = userRepository.save(user);
        LoggerUtil.info("User registered successfully: " + savedUser.getUsername());

        // Convert Set<Role> to Set<String>
        Set<String> roleNames = new HashSet<>();
        for (Role role : savedUser.getRoles()) {
            roleNames.add(role.getName());
        }

        return new RegisterResponseDTO(
                savedUser.getUsername(),
                savedUser.getEmail(),
                roleNames,
                "User registered successfully"
        );
    }

    public Optional<User> findByUsername(String username) {
        LoggerUtil.info("Fetching user by username: " + username);
        return userRepository.findByUsername(username);
    }
}
