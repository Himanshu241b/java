package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
