package ATMSimulator;

//exception to raise in case of Invalid pin entered by use while loggin in
public class InvalidPinException extends Exception{
    public InvalidPinException(String message){
        super(message);
    }
}
