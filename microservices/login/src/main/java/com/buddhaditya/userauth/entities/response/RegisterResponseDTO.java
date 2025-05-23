package com.buddhaditya.userauth.entities.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class RegisterResponseDTO {
    private String username;
    private String email;
    private Set<String> roles;
    private String message;
}
