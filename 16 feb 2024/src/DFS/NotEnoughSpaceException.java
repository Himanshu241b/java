package DFS;

//Exception to hancle exception of insuffient space availibility
public class NotEnoughSpaceException extends DFSException{
    public NotEnoughSpaceException(String message) {
        super(message);
    }
}
