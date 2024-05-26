package com.example.bankingApplication.service;

import com.example.bankingApplication.entity.Account;
import com.example.bankingApplication.entity.AccountType;
import com.example.bankingApplication.entity.User;
import com.example.bankingApplication.repository.AccountRepository;
import com.example.bankingApplication.repository.UserRepository;
import com.example.bankingApplication.utility.AccountNumberGenerator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final UserService userService;
    private final AccountNumberGenerator accountNumberGeneerator;
    public AccountService(UserRepository userRepository, AccountNumberGenerator accountNumberGeneerator, UserService userService, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.accountNumberGeneerator = accountNumberGeneerator;
        this.userService = userService;
    }
    public Account createAccount(Long userId, AccountType accountType) throws UserNotFoundException{
        User newAccountOwner = userRepository.findById(userId).orElse(null);
        if(newAccountOwner == null){
            throw new UserNotFoundException(userId);
        }
        Account newAccount = new Account();
        newAccount.setAccountNumber(accountNumberGeneerator.generateAccountNumber());
        newAccount.setBalance(BigDecimal.valueOf(0));
        newAccount.setAccountType(accountType);


        accountRepository.save(newAccount);
        newAccountOwner.getAccounts().add(newAccount);
        return newAccount;
    }

    public String getBalance(Long accountId, User loggedInUser) throws IllegalAccessException{
        Account userAccount = accountRepository.findById(accountId).orElse(null);
        return userAccount.getBalance().toString();

    }

    public static class UserNotFoundException extends EntityNotFoundException {
        public UserNotFoundException(Long userId) {
            super("User with id: " + userId + "not found");
        }
    }
}
