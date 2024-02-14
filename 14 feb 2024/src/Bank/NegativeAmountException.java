package Bank;

public class NegativeAmountException extends BankException {
    public NegativeAmountException(String message) {
        super(message);
    }
}

