package com.example.bankingApplication.utility;

import lombok.experimental.UtilityClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class AccountNumberGenerator {
    private static final String DATE_FORMAT = "yyyyMMddHHmmss";
    private static final int ACCOUNT_NUMBER_LENGTH = 16;

    public static String generateAccountNumber() {
        // Get current timestamp in the specified format
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern(DATE_FORMAT));

        // Generate random digits to complete the 16-digit account number
        StringBuilder accountNumberBuilder = new StringBuilder(timestamp);
        SecureRandom random = new SecureRandom();
        while (accountNumberBuilder.length() < ACCOUNT_NUMBER_LENGTH) {
            accountNumberBuilder.append(random.nextInt(10)); // Append random digit (0-9)
        }

        // Ensure the account number is exactly 16 digits long
        String accountNumber = accountNumberBuilder.toString();
        if (accountNumber.length() > ACCOUNT_NUMBER_LENGTH) {
            accountNumber = accountNumber.substring(0, ACCOUNT_NUMBER_LENGTH);
        }

        return accountNumber;
    }
}
