package com.example.jwtwithroles.dto;

import com.example.jwtwithroles.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private Long userId;
    private String userName;
    private String email;
    private String bio;
    private String image;
    private String token;
    private Set<Role> roles;
}
