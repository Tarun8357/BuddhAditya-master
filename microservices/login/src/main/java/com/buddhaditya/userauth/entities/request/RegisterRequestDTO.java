package com.buddhaditya.userauth.entities.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String gender;
    private String occupation;
    private Set<String> roles; // List of role names (["USER", "ADMIN", "MOD"])
}
