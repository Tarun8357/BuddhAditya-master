package com.buddhaditya.userauth.security;

import com.buddhaditya.userauth.jwtutils.JwtAuthFilter;
import com.buddhaditya.userauth.services.CustomUserDetailsService;
import com.buddhaditya.userauth.utils.LoggerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        LoggerUtil.info("Initializing Password Encoder (BCrypt)");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomUserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        LoggerUtil.info("Configuring security filter chain");

        http.csrf(AbstractHttpConfigurer::disable)  // Disable CSRF for token-based authentication
                .cors(cors -> cors.configurationSource(corsHandler())) // Enable CORS
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Make it stateless
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/login").permitAll()  // Public routes
                        .anyRequest().authenticated()  // Secure all other endpoints
                )
                .formLogin(AbstractHttpConfigurer::disable)  // Disable form-based login
                .logout(logout -> logout.logoutUrl("/auth/logout")) // Define logout URL
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter

        return http.build();
    }

    /**
     * CORS Configuration to allow requests from specified origins.
     */
    @Bean
    public CorsFilter corsFilter() {
        return new CorsFilter(corsHandler());
    }

    /**
     * CORS Handler to configure allowed origins, headers, and methods.
     */
    @Bean
    public UrlBasedCorsConfigurationSource corsHandler() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000", "http://yourfrontend.com")); // Allow specific origins
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allowed HTTP methods
        config.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type")); // Allowed headers
        config.setAllowCredentials(true); // Allow cookies or credentials

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply to all endpoints
        return source;
    }
}
