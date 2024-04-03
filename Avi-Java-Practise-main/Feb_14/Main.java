package Feb_14;

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        BankAccount account1 = new BankAccount("123456", 1000.0);
        BankAccount account2 = new BankAccount("789012", 500.0);

        bankingSystem.addAccount(account1);
        bankingSystem.addAccount(account2);

        try {
            bankingSystem.deposit("123456", 200.0);
            bankingSystem.withdraw("789012", 100.0);
            bankingSystem.transfer("123456", 300.0);

            // Simulate an error by attempting to withdraw more than the balance
            bankingSystem.withdraw("789012", 600.0);
        } catch (BankException e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();
        }

        bankingSystem.displayTransactions();
    }
}
