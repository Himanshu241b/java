package Feb_14;

public class NegativeAmountException extends BankException{
    public NegativeAmountException()
    {
        super("Amount cannot be less than or equal to zero.");
    }
}
