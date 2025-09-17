package com.buddhaditya.nucleus.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserInfoDto {
    private String userId;
    private String username;
    private String email;
    private Set<String> roles;
}
