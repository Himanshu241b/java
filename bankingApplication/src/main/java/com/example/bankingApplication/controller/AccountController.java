package com.example.bankingApplication.controller;

import com.example.bankingApplication.dto.CreateAccountDTO;
import com.example.bankingApplication.dto.CreateAccountResponseDTO;
import com.example.bankingApplication.dto.ErrorResponseDTO;
import com.example.bankingApplication.entity.Account;
import com.example.bankingApplication.entity.AccountType;
import com.example.bankingApplication.entity.User;
import com.example.bankingApplication.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;

    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create/{userId}/accountType/{accountType}")
    public String createAccountGet(){
        return "Account Created Successfully.";
    }

    @PostMapping("/create/{userId}/accountType/{accountType}")
    public ResponseEntity<CreateAccountResponseDTO> createAccount(@PathVariable("userId") Long userId, @PathVariable("accountType") AccountType accountType) throws AccountService.UserNotFoundException {
        Account newAccount = accountService.createAccount(userId, accountType);
        CreateAccountResponseDTO createAccountResponseDTO= modelMapper.map(newAccount, CreateAccountResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccountResponseDTO);
    }

    @GetMapping("/balance/{accountId}")
    public ResponseEntity<String> getBalance(@AuthenticationPrincipal User loggedInUser, @PathVariable("accountId") Long accountId)throws IllegalAccessException{

        String balance = accountService.getBalance(accountId, loggedInUser);

        return ResponseEntity.ok(balance);
    }


    @ExceptionHandler(
            {
                    AccountService.UserNotFoundException.class,
                    IllegalAccessException.class
            }
    )
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
        String message;
        HttpStatus status;
        if(exception instanceof AccountService.UserNotFoundException){
            message = exception.getMessage();
            status = HttpStatus.NOT_FOUND;
        }
        else if(exception instanceof IllegalAccessException){
            message = exception.getMessage();
            status = HttpStatus.FORBIDDEN;
        }
        else{
            message = "something went wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        ErrorResponseDTO errorResponse = ErrorResponseDTO.builder()
                .message(message)
                .build();
        return ResponseEntity.status(status).body(errorResponse);
    }

}
