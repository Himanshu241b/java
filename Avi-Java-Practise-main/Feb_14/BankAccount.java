package Feb_14;

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

    //deposit money
    public void deposit(double amount) throws NegativeAmountException
    {
        if(amount > 0){
            balance += amount;
            return;
        }
        throw new NegativeAmountException();
    }

    //withdraw money
    public void withdraw(double amount) throws BankException
    {
        if(amount > balance)
        {
            throw new BankException("Insufficient Funds!");
        }
        if(amount > 0){
            balance -= amount;
            return;
        }
        throw new NegativeAmountException();
    }

    public void transfer(double amount, BankAccount accountNumber) throws NegativeAmountException, BankException
    {
        if(amount > balance)
        {
            throw new BankException("Insufficient Funds!");
        }
        if(amount > 0){
            balance -= amount;
            accountNumber.deposit(amount);
            return;
        }

        throw new NegativeAmountException();
    }
}
