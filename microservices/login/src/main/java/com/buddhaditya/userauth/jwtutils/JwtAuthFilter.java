package com.buddhaditya.userauth.jwtutils;

import com.buddhaditya.userauth.utils.LoggerUtil;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    public JwtAuthFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        // Schedule periodic cleaning of token cache (every 15 minutes)
        scheduler.scheduleAtFixedRate(this::cleanTokenCache, 15, 15, TimeUnit.MINUTES);
    }

    // Simple in-memory token cache (Use Redis in production)
    private final Map<String, UserDetails> tokenCache = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private void cleanTokenCache() {
        LoggerUtil.debug("Cleaning token cache. Current size: " + tokenCache.size());
        tokenCache.clear();
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        try {
            String jwt = parseJwt(request);

            if (jwt != null) {
                // Get username from token
                String username = jwtService.extractUsername(jwt);

                // Only proceed if we have a username and no authentication is set
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // Check cache first
                    UserDetails userDetails = tokenCache.computeIfAbsent(username, k ->
                            userDetailsService.loadUserByUsername(username)
                    );

                    // Validate token
                    if (jwtService.validateToken(jwt, userDetails)) {
                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails,
                                        null,
                                        userDetails.getAuthorities()
                                );

                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                        LoggerUtil.info("JWT token validated successfully for user: " + username);
                    }
                }
            }
        } catch (ExpiredJwtException e) {
            LoggerUtil.debug("JWT token has expired: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token expired");
            return;
        } catch (SignatureException e) {
            LoggerUtil.error("Invalid JWT signature: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid token signature");
            return;
        } catch (MalformedJwtException e) {
            LoggerUtil.error("Invalid JWT token: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Malformed token");
            return;
        } catch (UnsupportedJwtException e) {
            LoggerUtil.error("JWT token is unsupported: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unsupported token");
            return;
        } catch (Exception e) {
            LoggerUtil.error("Authentication error: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Authentication error");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }

    @Override
    public void destroy() {
        scheduler.shutdown();
    }
}
