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
        // random object to generate random balance
        Random random = new Random(); 
        
        Scanner sc = new Scanner(System.in);
        
        // atm object to perform various operations in the atm
        ATM atm = new ATM(); 
        // to perform various operations in the account
        Account account = null; 
        Bank userBank= null;

        // making objects of accounts of different types
        for(int i = 0; i < 20; ++i){
            String name = String.format("Customer"+(i+1));
            String pin = String.format("%04d", i+1);
            String accountNumber = String.format("%010d", i + 200000);  
            String ifsc =(i / 7 + 1) + "000000000" + (i % 7 + 1);    
            double balance =  500000*random.nextDouble();

            String cardNumber = generateUniqueNumber();
            hdfcAccounts[i] = new Account(accountNumber,pin, cardNumber, name, balance, "HDFC"+ifsc);
            HDFC.addAccount(hdfcAccounts[i]);

            cardNumber = generateUniqueNumber();
            sbiAccounts[i] = new Account(accountNumber,pin, cardNumber, name, balance, "SBI"+ifsc);
            SBI.addAccount(sbiAccounts[i]);

            cardNumber = generateUniqueNumber();
            iciciAccounts[i] = new Account(accountNumber,pin, cardNumber, name, balance, "ICICI"+ifsc);
            ICICI.addAccount(iciciAccounts[i]);
           }

           System.out.println("name:"+hdfcAccounts[0].getName());
           System.out.println("Balance:"+hdfcAccounts[0].getBalance());
           System.out.println("Card:"+hdfcAccounts[0].getCardNumber());
           System.out.println("pin:"+hdfcAccounts[0].getPin());
           System.out.println("ifsc:"+hdfcAccounts[0].getIfsc());
           System.out.println("Acc. no."+hdfcAccounts[0].getaccountNumber());

           System.out.println("name:"+iciciAccounts[1].getName());
           System.out.println("Balance:"+iciciAccounts[1].getBalance());
           System.out.println("Card:"+iciciAccounts[1].getCardNumber());
           System.out.println("pin:"+iciciAccounts[1].getPin());
           System.out.println("ifsc:"+iciciAccounts[1].getIfsc());
           System.out.println("Acc. no."+iciciAccounts[1].getaccountNumber());

           
           char choice;
           do{
                System.out.println("*****************ATM***************** ");
                System.out.println("press 1: To login with card number and pin");
                System.out.println("press 2: To perform a transaction");
                System.out.println("press 3: To withdraw");
                System.out.println("press 4: To Log Out or end session");
                choice = sc.next().charAt(0);
                switch (choice) {
                    case '1'://login with card number and pin
                        try{
                        
                        boolean loop = true;
                        do{
                            System.out.println("Select your bank:");
                            System.out.println("1. hdfc\n2. sbi\n3. icici\n4. Exit..");
                            char choice1 = sc.next().charAt(0);
                            switch(choice1) {
                                case '1': 
                                    userBank = new HDFC();
                                    account = atm.login(userBank, sc);
                                    loop = false;
                                    break;
                                case '2': 
                                    userBank = new SBI();
                                    account = atm.login(userBank, sc);
                                    loop = false;
                                    break;
                                case '3': 
                                    userBank = new ICICI();
                                    account = atm.login(userBank, sc);
                                    loop = false;
                                    break;
                                case '4': 
                                    System.exit(0);
                                default:
                                    System.out.println("Enter valid choice");
                            }
                        }while(loop);
                        }
                        catch(InvalidPinException | AccountNotFoundException e){
                            System.err.println(e.getMessage());
                        }
                        break;
                    case '2': // to perform a transaction
                        // if user not logged in 
                        if(account == null){
                            System.out.println("Login first...");
                            break;
                        }
                        try{
                        Bank recipientBank;
                        boolean loop = true;
                        do{
                            System.out.println("Select recipient bank:");
                            System.out.println("1. hdfc\n2. sbi\n3. icici\n4. Exit..");
                            char choice1 = sc.next().charAt(0);
                            if(userBank == null){
                                System.out.println("Please login first");
                                break;
                            }
                            
                            switch(choice1) {
                                case '1': 
                                    recipientBank = new HDFC();
                                    atm.transaction(recipientBank, account, userBank, sc);
                                    loop = false;
                                    break;
                                case '2': 
                                    recipientBank = new SBI();
                                    atm.transaction(recipientBank, account, userBank, sc);
                                    break;
                                case '3': 
                                    recipientBank = new ICICI();
                                    atm.transaction(recipientBank, account,userBank, sc);
                                    loop = false;
                                    break;
                                case '4': 
                                    System.exit(0);
                                default:
                                    System.out.println("Enter valid choice");
                            }
                        }while(loop);
                    }
                    catch(AccountNotFoundException | InsufficientFundsException e){
                        System.err.println(e.getMessage());
                    }
                        break;
                    case '3': // to withdraw money from logged in account
                        try{
                        if(account == null){
                            throw new AccountNotFoundException("Please Login first...");
                        }
                        account.withdraw(sc);
                        }
                        catch(InsufficientFundsException |AccountNotFoundException e){ 
                            System.out.println(e.getMessage());
                        }
                        break;
                    case '4':
                        account = null;
                        System.out.println("Logged out successfully");
                        break;
                    default:
                        System.out.println("Enter valid choice");
                }

           }
           while(choice !='0');
    }
    // generates unique card number string
    public static String generateUniqueNumber() {
        StringBuilder sb = new StringBuilder();

        // Generate the first 3 groups of numbers
        for (int i = 0; i < 3; i++) {
            sb.append(generateRandomGroup());
            sb.append("-");
        }

        // Generate the last group of numbers
        sb.append(String.format("%04d", new Random().nextInt(10000)));

        return sb.toString();
    }
    //generates a group of 4 random numbers
    public static String generateRandomGroup() {
        Random random = new Random();
        StringBuilder group = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            group.append(random.nextInt(10));
        }

        return group.toString();
    }
}


