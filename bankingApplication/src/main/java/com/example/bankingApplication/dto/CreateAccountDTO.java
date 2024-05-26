package com.example.bankingApplication.dto;

import com.example.bankingApplication.entity.AccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountDTO {
    private String accountNumber;
    private BigDecimal balance;
    private AccountType accountType;
    private String securityPin;
}
