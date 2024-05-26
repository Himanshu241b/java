package com.example.bankingApplication.repository;

import com.example.bankingApplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getByAccountNumber(String accountNumber);
}
