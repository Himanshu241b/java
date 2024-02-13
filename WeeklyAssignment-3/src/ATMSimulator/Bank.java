package ATMSimulator;

//import statements
import java.util.*;

//abstract class bank
public abstract class Bank {
    private static List<Account> accounts = new ArrayList<Account>();

    //abstract method to get interest rate
    public abstract double getInterestRate();

    //method to add account to accounts list

}
//HdFC CLass extending bank
class HDFC extends Bank {
    private static List<Account> hdfcAccounts = new ArrayList();
    
    //method to add account to hdfc accounts list

    @Override
    public double getInterestRate() {
        return 6.5; // Example specific interest rate
    }

    
}

//Sbi class extending bank class
class SBI extends Bank {
    private static List<Account> sbiAccounts = new ArrayList();
    
    //method to add account to sbiAccounts list

    @Override
    public double getInterestRate() {
        return 6.5; // Example specific interest rate
    }

    
}

// ICICI class extending bank class
class ICICI extends Bank {
    private static List<Account> iciciAccounts = new ArrayList();
    
    //method to add account to icici accounts list

    @Override
    public double getInterestRate() {
        return 6.5; // Example specific interest rate
    }

    
}



