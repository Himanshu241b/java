package Feb_14;
import java.util.*;

public class BankingSystem {
    private List<BankAccount> accounts;
    private List<Transaction> transactions;

    public BankingSystem() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    //add accounnt
    public void addAccount(BankAccount account)
    {
        accounts.add(account);
        System.out.println("Account added successfully");
    }
    //remove acconut
    public void removeAccount(BankAccount account)
    {
        accounts.remove(account);
        System.out.println("Account deleted successfully");
    }

    //deposit money by finding the account number
    public void deposit(String accountNumber, double amount) throws BankException
    {
        try{
            BankAccount account = findAccount(accountNumber);
            account.deposit(amount);
            transactions.add(new Transaction(UUID.randomUUID().toString(), "Deposit" , amount));
        }
        catch(BankException e){
            throw new BankException("Error occured");
        }
    }

    //withdraw money by finding the account number
    public void withdraw(String accountNumber, double amount) throws BankException
    {
        try{
            BankAccount account = findAccount(accountNumber);
            account.withdraw(amount);
            transactions.add(new Transaction(UUID.randomUUID().toString(), "Withrawal", amount));
        }
        catch(BankException e){
            throw new BankException("Error Occurred!");
        }
    }

    //transfer money by finding the account number
    public void transfer(String accountNumber, double amount) throws BankException
    {
        try{
            BankAccount account = findAccount(accountNumber);
            account.transfer(amount, account);
        }
        catch(BankException e)
        {
            throw new BankException("Bank Error");
        }
    }


    //method to find bank account by account number
    public BankAccount findAccount(String accountNumber) throws BankException
    {
        for(BankAccount acc: accounts)
        {
            if(Objects.equals(acc.getAccountNumber(), accountNumber))
            {
                return acc;
            }
        }
        throw new BankException("Invalid Account Number!");
    }

    //displaying the trnx
    public void displayTransactions() {
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("ID: " + transaction.getTransactionId() +
                    ", Type: " + transaction.getTransactionType() +
                    ", Amount: $" + transaction.getAmount());
        }
    }

}
