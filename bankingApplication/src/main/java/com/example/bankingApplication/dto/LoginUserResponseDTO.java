package com.example.bankingApplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LoginUserResponseDTO {
    private Long userId;
    private String email;
    private String token;
}
