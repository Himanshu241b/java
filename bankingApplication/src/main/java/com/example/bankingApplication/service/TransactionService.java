package com.example.bankingApplication.service;

import com.example.bankingApplication.dto.CreateTransactionDTO;
import com.example.bankingApplication.entity.*;
import com.example.bankingApplication.repository.AccountRepository;
import com.example.bankingApplication.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@Transactional
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Transaction transaction(User loggedInUser, CreateTransactionDTO createTransactionDTO) throws InsufficientFundsException{
        Account sourceAccount = loggedInUser.getAccounts().get(0);


        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        switch(createTransactionDTO.getTransactionType()){
            // when transaction is of deposit type
            case TransactionType.DEPOSIT:
                BigDecimal balanceAfterDeposit = sourceAccount.getBalance().add(createTransactionDTO.getAmount());
                sourceAccount.setBalance(balanceAfterDeposit);
                accountRepository.save(sourceAccount);
                Transaction depositTransaction = new Transaction();
                depositTransaction.setAmount(createTransactionDTO.getAmount());
                depositTransaction.setTransactionStatus(TransactionStatus.COMPLETED);
                depositTransaction.setTransactionType(TransactionType.DEPOSIT);
                depositTransaction.setDateTime(dateTimeFormatter.format(dateTime));
                depositTransaction.setSourceAccountNumber(sourceAccount.getAccountNumber());
                depositTransaction.setReferenceNumber(generateTransactionId());
                transactionRepository.save(depositTransaction);
                return depositTransaction;

            //when transaction is of withdrawal type
            case TransactionType.WITHDRAW:
                if(sourceAccount.getBalance().compareTo(createTransactionDTO.getAmount()) < 0){
                    throw new InsufficientFundsException(sourceAccount.getAccountNumber());
                }
                BigDecimal balanceAfterWithdrawal = sourceAccount.getBalance().subtract(createTransactionDTO.getAmount());
                sourceAccount.setBalance(balanceAfterWithdrawal);
                accountRepository.save(sourceAccount);
                Transaction withdrawTransaction = new Transaction();
                withdrawTransaction.setAmount(createTransactionDTO.getAmount());
                withdrawTransaction.setTransactionStatus(TransactionStatus.COMPLETED);
                withdrawTransaction.setTransactionType(TransactionType.WITHDRAW);
                withdrawTransaction.setDateTime(dateTimeFormatter.format(dateTime));
                withdrawTransaction.setSourceAccountNumber(sourceAccount.getAccountNumber());
                withdrawTransaction.setReferenceNumber(generateTransactionId());
                transactionRepository.save(withdrawTransaction);
                return withdrawTransaction;

            //when transaction is of transfer type
            case TransactionType.TRANSFER:
                Account destinationAccount = accountRepository.getByAccountNumber(createTransactionDTO.getDestinationAccountNumber());

                BigDecimal deductableAmount = createTransactionDTO.getAmount().multiply(new BigDecimal(0.01));

                if(sourceAccount.getBalance().compareTo(deductableAmount.add(createTransactionDTO.getAmount())) < 0){
                    throw new InsufficientFundsException(sourceAccount.getAccountNumber());
                }

                BigDecimal sourceBalanceAfterTransfer = sourceAccount.getBalance().subtract(deductableAmount.add(createTransactionDTO.getAmount()));
                sourceAccount.setBalance(sourceBalanceAfterTransfer);
                BigDecimal destinationAmountAfterTransfer = destinationAccount.getBalance().add(createTransactionDTO.getAmount());
                destinationAccount.setBalance(destinationAmountAfterTransfer);
                accountRepository.save(destinationAccount);
                accountRepository.save(sourceAccount);
                Transaction transferTransaction = new Transaction();
                transferTransaction.setAmount(createTransactionDTO.getAmount());
                transferTransaction.setTransactionStatus(TransactionStatus.COMPLETED);
                transferTransaction.setTransactionType(TransactionType.TRANSFER);
                transferTransaction.setDateTime(dateTimeFormatter.format(dateTime));
                transferTransaction.setSourceAccountNumber(sourceAccount.getAccountNumber());
                transferTransaction.setDestinationAccountNumber(createTransactionDTO.getDestinationAccountNumber());
                transferTransaction.setReferenceNumber(generateTransactionId());
                transferTransaction.setFee(deductableAmount);
                transactionRepository.save(transferTransaction);
                return transferTransaction;

        }
        return null;
    }
    
        public static String generateTransactionId() {

            Instant now = Instant.now();
            long timestamp = now.toEpochMilli();

            UUID randomUUID = UUID.randomUUID();

            return "TRX-" + timestamp + "-" + randomUUID.toString();
        }

    public static class InsufficientFundsException extends Exception{
        public InsufficientFundsException(String accountNumber){
            super("Insufficient funds in account number " + accountNumber);
        }
    }
}
