package com.example.bankingApplication.controller;

import com.example.bankingApplication.dto.CreateTransactionDTO;
import com.example.bankingApplication.dto.ErrorResponseDTO;
import com.example.bankingApplication.entity.Transaction;
import com.example.bankingApplication.entity.User;
import com.example.bankingApplication.repository.UserRepository;
import com.example.bankingApplication.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transaction")
@Transactional
public class TransactionController {

    private final TransactionService transactionService;
    private final UserRepository userRepository;

    public TransactionController(TransactionService transactionService, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public ResponseEntity<Transaction> transaction(@AuthenticationPrincipal User loggedInUser, @RequestBody CreateTransactionDTO createTransactionDTO) throws TransactionService.InsufficientFundsException {
        User sessionUser = userRepository.findById(loggedInUser.getUserId()).orElse(null);
        Transaction newTransaction = transactionService.transaction(sessionUser, createTransactionDTO);
        return ResponseEntity.status(HttpStatus.OK).body(newTransaction);
    }


    @ExceptionHandler(
            {
                    TransactionService.InsufficientFundsException.class
            }
    )
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception exception){
        String message;
        HttpStatus status;
        if(exception instanceof TransactionService.InsufficientFundsException) {
            message = exception.getMessage();
            status = HttpStatus.BAD_REQUEST;
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
