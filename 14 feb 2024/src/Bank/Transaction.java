package Bank;

//transaction class
public class Transaction {
    private String transactionId;
    private String transactionType;
    private double amount;
    private BankAccount bankAccount;

    public Transaction(String transactionId, String transactionType, double amount, BankAccount bankAccount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    //getter to get transactionId
    public String getTransactionId() {
        return transactionId;
    }

    // to get transactionType
    public String getTransactionType() {
        return transactionType;
    }

    //to get amount
    public double getTransactionAmount() {
        return amount;
    }
    // method to deposit funds
    public void deposit(double amount) throws NegativeAmountException {
        if(amount < 0)
            throw new NegativeAmountException("amount must be positive");
        bankAccount.addBalance(amount);
    }
    // method to withdraw funds
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > bankAccount.getBalance()) {
            throw new InsufficientBalanceException("Insufficient funds");
        }
        bankAccount.withdrawBalance(amount);
        
    }
    //method to transfer funds
    public void transfer(BankAccount recipient, double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Transfer amount cannot be negative");
        }
        try{
        bankAccount.withdrawBalance(amount);
        }
        catch(InsufficientBalanceException e){
            System.out.println("Insufficient funds");
            return;
        }
        recipient.addBalance(amount);
    }
}
