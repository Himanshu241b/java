package Bank;

//import statements
import java.util.*;
import java.util.UUID;

public class BankingSystem {
    private static List<BankAccount> bankAccounts;
    private static List<Transaction> transactions;
    BankingSystem(){
        bankAccounts = new ArrayList<BankAccount>();
        transactions = new ArrayList<Transaction>();
        
    }
  

    //getter to return list of bank accounts
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
    // getter to return list of transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }
    // to add to list of accounts
    public void addBankAccount(BankAccount account){
        bankAccounts.add(account);
    }
    //to add to list of transactions
    public void addTransactions(Transaction transaction){
        transactions.add(transaction);
    }

    //method to perform transactions
    public void transaction(BankingSystem bs, Scanner sc) throws AccountNotFoundException{
        try{
        System.out.println("Enter your account number...");
        String accountNumber = sc.next();
        BankAccount bankAccount = null;
        for(BankAccount account : bs.getBankAccounts())
            if(account.getAccountNumber().equals(accountNumber))
                bankAccount = account;
        if(bankAccount == null)
            throw new AccountNotFoundException("Account not found");
        System.out.println("Enter amount you want to deposit or withdraw:");
        double amount = sc.nextDouble();
        System.out.println("Enter the type of transaction \n0.withdrawal\n1.deposit");
        int choice = sc.nextInt();
        String uuid = UUID.randomUUID().toString();
        if(choice == 1){
            
            try{
            Transaction depositTransaction = new Transaction(uuid,"deposit", amount, bankAccount);
            depositTransaction.deposit(amount);
            addTransactions(depositTransaction);
            System.out.println("transaction id:"+depositTransaction.getTransactionId()+"\n Transaction type:"+depositTransaction.getTransactionType()+"\n Transaction amount:"+depositTransaction.getTransactionAmount());
            }
            catch(NegativeAmountException e){
                System.err.println(e.getMessage());
                return;
            }
        }
        else {
            try{
            Transaction withdrawTransaction = new Transaction(uuid, "withdrawal", amount, bankAccount);
            withdrawTransaction.withdraw(amount);
            addTransactions(withdrawTransaction);
            System.out.println("transaction id:"+withdrawTransaction.getTransactionId()+"\n Transaction type:"+withdrawTransaction.getTransactionType()+"\n Transaction amount:"+withdrawTransaction.getTransactionAmount());
            }
            catch(InsufficientBalanceException e){
                System.err.println(e.getMessage());
                return;
            }
        }
    }
        catch(InputMismatchException e){
            System.err.println("Enter valid input");
            sc.nextLine(); // to avoid nextline charcter entered in last loc
        }
        
       
    }
    public void transfer(BankingSystem bs, Scanner sc) throws AccountNotFoundException{
        try{
        System.out.println("Enter your account Number:");
        String senderAccountNumber = sc.next();
        System.out.println("Enter recipient account Number:");
        String recipientAccountNumber = sc.next();
        BankAccount recipient = null;
        for(BankAccount account: bs.getBankAccounts())
            if(account.getAccountNumber().equals(recipientAccountNumber))
                recipient = account;
        if(recipient == null)
            throw new AccountNotFoundException("recipient not a bank account");
            BankAccount sender = null;
            for(BankAccount account: bs.getBankAccounts())
                if(account.getAccountNumber().equals(senderAccountNumber))
                    sender = account;
        if(sender == null)
            throw new AccountNotFoundException("sender not a bank account");
        System.out.println("Enter the amount you want to transfer:");
        double amount = sc.nextDouble();
        try{
            String uuid = UUID.randomUUID().toString();
            Transaction transfer = new Transaction(uuid, "transfer", amount, sender);
            transfer.transfer(recipient, amount);
            transactions.add(transfer);
            System.out.println("transaction id:"+transfer.getTransactionId()+"\n Transaction type:"+transfer.getTransactionType()+"\n Transaction amount:"+transfer.getTransactionAmount());
        }
        catch(NegativeAmountException e){
            System.out.println(e.getMessage());
            return;
        }
    }
    catch(InputMismatchException e){
        System.err.println("Enter valid input");
        sc.nextLine();
    }
    }
}
