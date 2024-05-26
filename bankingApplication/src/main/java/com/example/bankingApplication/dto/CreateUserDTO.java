package com.example.bankingApplication.dto;


import com.example.bankingApplication.entity.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDTO {
    private String password;
    private String email;
    private String name;
    private String contact;
    private String adhaarNumber;
    private String panNumber;
    private AccountType accountType;
    private int propertyNumber;
    private String addressType;
    private int streetNumber;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String role;
}
