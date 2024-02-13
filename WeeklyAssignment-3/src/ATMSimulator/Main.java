package ATMSimulator;

// import statements
import java.util.*;
// main class
public class Main {

    public static void main(String[] args) {
        // arrays to store 20 objects of accounts
        Account[] hdfcAccounts = new Account[20];
        Account[] sbiAccounts = new Account[20];
        Account[] iciciAccounts = new Account[20];
        Random random = new Random(); // random object to generate random balance
        Scanner sc = new Scanner(System.in);

        // making objects of accounts of different types
        for(int i = 0; i < 20; ++i){
            String name = String.format("Customer"+(i+1));
            String cardNumber = String.format("1234-5678-9012-%04d", i + 1); 
            String pin = String.format("%04d", i+1);
            String accountNumber = String.format("%010d", i + 200000);  
            String ifsc =(i / 7 + 1) + "000000000" + (i % 7 + 1);    
            double balance =  500000*random.nextDouble();
            hdfcAccounts[i] = new HDFCAccount(accountNumber,pin, cardNumber, name, balance, "HDFC"+ifsc);
            sbiAccounts[i] = new SBIAccount(accountNumber,pin, cardNumber, name, balance, "SBI"+ifsc);
            iciciAccounts[i] = new ICICIAccount(accountNumber,pin, cardNumber, name, balance, "ICICI"+ifsc);
           }
           System.out.println("name:"+hdfcAccounts[0].getName());
           System.out.println("Balance:"+hdfcAccounts[0].getBalance());
           System.out.println("Card:"+hdfcAccounts[0].getCardNumber());
           System.out.println("ifsc:"+hdfcAccounts[0].getIfsc());
           char choice;
           do{
                System.out.println("*****************ATM***************** ");
                System.out.println("press 1: To login with card number and pin");
                System.out.println("press 2: To perform a transaction");
                System.out.println("press 3: To withdraw");
                choice = sc.next().charAt(0);

                switch (choice) {
                    case value:
                        
                        break;
                
                    default:
                        break;
                }

           }
           while(choice !='0');
    }
}


