package Bank;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public void addBalance(double amount) {
        balance += amount;
        System.out.println(amount +"Balance added to bank:  " + accountNumber);
        System.out.println("New balance:"+ balance);
    }
    // withdraw balance from account
    public void withdrawBalance(double amount) throws InsufficientBalanceException {
        if(balance < amount)
            throw new InsufficientBalanceException("Insufficient balance");
        balance -= amount;
        System.out.println(amount +" withdrawn from bank:"+ accountNumber);
        System.out.println("Balance left:"+ balance);
    }
}
