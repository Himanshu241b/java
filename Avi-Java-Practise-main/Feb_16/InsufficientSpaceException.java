package Feb_16;

public class InsufficientSpaceException extends DFSException{
    public InsufficientSpaceException() {
        super("Insufficient space on the server.");
    }

}
