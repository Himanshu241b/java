package com.example.bankingApplication.service;

import com.example.bankingApplication.entity.Account;
import com.example.bankingApplication.repository.AccountRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class InterestService {

    private final AccountRepository accountRepository;

    public InterestService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Async
    @Scheduled(cron = "0 0 1 1 * *") // Run at 1:00 AM on the 1st day of every year
    public void applyInterest() {
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            BigDecimal currentBalance = account.getBalance();
            BigDecimal interestAmount = currentBalance.multiply(BigDecimal.valueOf(0.03)); // 3% interest
            BigDecimal newBalance = currentBalance.add(interestAmount);
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
    }
}
