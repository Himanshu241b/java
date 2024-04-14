package com.example.taskmanagerspring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDTO {
    private String username;
    private String password;
    private String email;
}
