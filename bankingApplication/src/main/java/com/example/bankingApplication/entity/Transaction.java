package com.example.bankingApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long transactionId;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private BigDecimal amount;

    private String dateTime;

    private String sourceAccountNumber;

    private String destinationAccountNumber;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    private String referenceNumber;

    private BigDecimal fee;
}
