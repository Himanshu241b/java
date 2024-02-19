package ATMSimulator;

//import statements
import java.util.*;

//abstract class bank
public  abstract class Bank {

    public abstract List<Account> getAccounts();
    public abstract void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException;
    public abstract void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException;
}
//HdFC CLass extending bank
class HDFC extends Bank {
    private static List<Account> hdfcAccounts = new ArrayList();
    private String name = "hdfc";
    //method to add account to hdfc accounts list
    public static void addAccount(Account account) {
        hdfcAccounts.add(account);
    }
    //mehod to get accounts list
    @Override
    public List<Account> getAccounts() {
        return hdfcAccounts;
    } 
   
    
    // method to deposit amount
    @Override
    public void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException {
        Account recipientAccount = null;
        for(Account account :getAccounts())
            if(account != null && account.getaccountNumber() != null && account.getaccountNumber().equals(recipientAccountNumber))
                recipientAccount = account; 
        if(recipientAccount == null)
            throw new AccountNotFoundException("Account of recipient does not exist");
        recipientAccount.addBalance(amount);
    }
    //method to get interest rate
    
    public double getInterestRate() {
        return 6.5; // Example specific interest rate
    }
    //method to deduct money from sender's account while transfer
    @Override  
    public void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException{
        Account senderAccount = null;
        for(Account account :getAccounts())
            if(account != null && account == userAccount)
                senderAccount = account; 
        if(senderAccount == null)
            throw new AccountNotFoundException("Account of recipient does not exist");
        senderAccount.deduct(amount, 0.01);//calls account class method to deduct with specific charges
    }
    
}

//Sbi class extending bank class
class SBI extends Bank {
    private static List<Account> sbiAccounts = new ArrayList();
    private String name = "sbi";
    //method to add account to sbiAccounts list
    public static void addAccount(Account account) {
        sbiAccounts.add(account);
    }
    //method to get accounts list
    @Override
    public List<Account> getAccounts() {
        return sbiAccounts;
    }
    //deposits to account
    @Override
    public void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException {
        Account recipientAccount = null;
        for(Account account :getAccounts())
            if(account != null && account.getaccountNumber() != null && account.getaccountNumber().equals(recipientAccountNumber))
                recipientAccount = account; 
        if(recipientAccount == null)
            throw new AccountNotFoundException("Account of recipient does not exist");
        recipientAccount.addBalance(amount);
        
    }
    // method to get interest rate
    public double getInterestRate() {
        return 6.5; // Example specific interest rate
    }
    // method to deduct money from sender's account while transfer
    @Override  
    public void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException, AccountException{
        Account senderAccount = null;
        for(Account account :getAccounts())
            if(account != null && account == userAccount)
                senderAccount = account; 
        if(senderAccount == null)
            throw new AccountNotFoundException("Account of recipient does not exist");
        senderAccount.deduct(amount, 0.03);//calls account class method to deduct with specific charges
    }
    
}

// ICICI class extending bank class
class ICICI extends Bank {
    private static List<Account> iciciAccounts = new ArrayList();
    private String name = "icici";
    //method to add account to icici accounts list
    public static void addAccount(Account account) {
        iciciAccounts.add(account);
    }
    //method to deposit
    @Override
    public void deposit(String recipientAccountNumber, double amount) throws AccountNotFoundException {
        Account recipientAccount = null;
        for(Account account :getAccounts())
            if(account != null && account.getaccountNumber() != null && account.getaccountNumber().equals(recipientAccountNumber))
                recipientAccount = account; 
        if(recipientAccount == null)
            throw new AccountNotFoundException("Account of recipient does not exist");
        recipientAccount.addBalance(amount);
    }
    //mehtod to get interest rate
    public double getInterestRate() {
        return 6.5; // Example specific interest rate
    }
    //method to get accounts list
    @Override
    public List<Account> getAccounts(){
        return iciciAccounts;
    }
    //method to deduct money from sender's account while transfer
    @Override  
    public void deduct(Account userAccount, double amount) throws AccountNotFoundException, InsufficientFundsException{
        Account senderAccount = null;
        for(Account account :getAccounts())
            if(account != null && account == userAccount)
                senderAccount = account; 
        if(senderAccount == null)
            throw new AccountNotFoundException("Account of recipient does not exist");
        senderAccount.deduct(amount, 0.02);  //calls account class method to deduct with specific charges
    }
    
}



