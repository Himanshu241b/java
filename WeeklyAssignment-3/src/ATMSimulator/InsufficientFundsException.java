package ATMSimulator;

// exception to raise in case of insufficient money in user account
public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message) {
        super(message);
    }
}
