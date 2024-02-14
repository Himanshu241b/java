package Bank;

//imports
import java.util.Scanner;
public class Main{
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    BankingSystem bs = new BankingSystem();
    BankAccount account1 = new BankAccount("12345678", 10000);
    bs.addBankAccount(account1);
    BankAccount account2 = new BankAccount("12345679", 20000);
    bs.addBankAccount(account2);
    char choice;
    do{
        
        System.out.println("press 1: To perform a transaction");
        System.out.println("press 2: To transfer money");
        System.out.println("press 0: To terminate...");
        choice = sc.next().charAt(0);
        
        switch (choice) {
            case '1':
                try{
                bs.transaction(bs, sc);
                }catch(BankException e)
                {
                    System.err.println(e.getMessage());
                }
                break;
            case '2':
            try{
                bs.transfer(bs, sc);
            }
            catch(BankException e){
                System.out.println(e.getMessage());
            }
            break;
            case '0':
                System.out.println("Terminating...");
                System.exit(0);
                
            default:
                System.out.println("Enter valid input");
        }
    }
    while(choice != '0');
}
}
