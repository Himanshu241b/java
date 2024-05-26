package com.example.bankingApplication.dto;

import com.example.bankingApplication.entity.TransactionStatus;
import com.example.bankingApplication.entity.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateTransactionDTO {
    private TransactionType transactionType;

    private BigDecimal amount;

    private String destinationAccountNumber;

}
