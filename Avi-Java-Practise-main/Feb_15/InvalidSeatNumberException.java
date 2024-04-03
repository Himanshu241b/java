package Feb_15;

public class InvalidSeatNumberException extends ReservationException{
    public InvalidSeatNumberException()
    {
        super("Invalid Seat Number. Please provide a valid one.");
    }
}
