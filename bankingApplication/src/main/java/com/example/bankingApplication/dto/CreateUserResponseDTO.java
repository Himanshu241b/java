package com.example.bankingApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserResponseDTO {
    private String message;
    private String email;
    private String contact;
    private String  name;
}
