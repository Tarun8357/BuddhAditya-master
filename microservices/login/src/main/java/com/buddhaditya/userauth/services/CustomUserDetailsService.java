package com.buddhaditya.userauth.services;

import com.buddhaditya.userauth.entities.Role;
import com.buddhaditya.userauth.entities.User;
import com.buddhaditya.userauth.repository.interfaces.UserRepository;
import com.buddhaditya.userauth.utils.LoggerUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoggerUtil.info("Loading user by username: " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    LoggerUtil.error("User not found: " + username);
                    return new UsernameNotFoundException("User not found: " + username);
                });

        // Extract role names from Role entities
        String[] roles = user.getRoles().stream()
                .map(Role::getName)
                .toArray(String[]::new);

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(roles) // Use extracted role names
                .build();
    }
}
