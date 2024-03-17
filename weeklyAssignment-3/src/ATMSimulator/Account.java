package ATMSimulator;

//imports
import java.util.*;
public  class Account {

    private String accountNumber;
    private String pin;
    private String name;
    private double balance;
    private String cardNumber;
    private String ifsc;
    private boolean blocked = false;
    
    
    public Account(String accountNumber,String pin,String cardNumber, String name, double balance, String ifsc) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.ifsc = ifsc;
    }


    //method to set account status (blocked or not)
    public void setBlocked(){
        blocked = true;
    }
    public boolean getBlocked(){
        return blocked;
    }
    public String getName(){
        return name;
    }
    public String getaccountNumber(){
        return accountNumber;
    }
    public String getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public String getIfsc(){
        return ifsc;
    }
    public void setBalance(double remaining){
        balance = remaining;
    }
    
     
    // method to add balance to recipient account while transferring money
    public void addBalance(double amount){
        balance += amount;
        System.out.println("Amount: " + amount+" added to account"+ getName());
    }
    // 
     public void deduct(double amount, double charges) throws InsufficientFundsException{
        double accountBalance = getBalance();
        if(accountBalance < (amount + amount*charges))
            throw new InsufficientFundsException(getName()+" --->Insufficient funds in your account ");
        accountBalance -= amount;   
        accountBalance -= (amount*charges);
        System.out.println("Your account is deducted "+(amount*charges+amount));
        setBalance(accountBalance);
        System.out.println("remaining balance"+ balance);

     }
    // method to withdraw money from account 
    public void withdraw(Scanner sc) throws InsufficientFundsException{    
        System.out.println("Enter amount you want to withdraw:");
        double amount = sc.nextDouble();
        if(amount > balance) 
            throw new InsufficientFundsException("Account does not have enough funds");
        balance = getBalance();
        balance -= amount;
        setBalance(balance);
        System.out.println("your account is deducted "+amount);
        System.out.println("Remaining Balance:"+balance);
    }
}   
