package com.buddhaditya.userauth.entities.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponseDTO {
    private String username;
    private String token;
    private Set<String> roles;
}
