package ATMSimulator;

//import Statements
import java.util.Scanner;
public class ATM {
    //method to perform a transaction
    public void transaction(Bank recipientBank, Account userAccount,Bank userBank, Scanner sc) throws AccountNotFoundException, InsufficientFundsException{
        System.out.println("Enter account number you want to transfer money to:");
        String recipientAccountNumber = sc.next();
       
        System.out.println("Enter amount you want to transfer:");
        double amount = sc.nextDouble();
        recipientBank.deposit(recipientAccountNumber, amount);
        userBank.deduct(userAccount, amount);

    }

    //mehtod to login in atm with card number and pin
    public Account login(Bank bank, Scanner sc) throws InvalidPinException, AccountNotFoundException {
        
        System.out.println("Enter your card number:");
        String cardNumber = sc.next();
        Account loginAccount = null;
        for(Account account : bank.getAccounts())
            if (account != null && account.getCardNumber() != null && account.getCardNumber().equals(cardNumber)) {
            loginAccount = account;
            break; 
        }
        
        if(loginAccount == null)
            throw new AccountNotFoundException("Account not found");
        if(loginAccount.getBlocked()){
            throw new AccountNotFoundException("Account already blocked");
        }
        int count = 3;  // gives three attempts to user to enter the pin
        while(count > 0){ // blocks the account if all attempts go invalid
            System.out.println("Enter your Pin:");
            System.out.println(count+"attempts left");
            --count;
            String pin = sc.next();
            if(pin.equals(loginAccount.getPin())){
                System.out.println("Logged in as " + loginAccount.getName());
                break;
            }
        }
        if(count == 0){
            loginAccount.setBlocked();
            throw new InvalidPinException(" **********Pin incorrect 3 times.**********\n**********Your card has been blocked.**********");
        }
        
        return loginAccount;
    }
}
