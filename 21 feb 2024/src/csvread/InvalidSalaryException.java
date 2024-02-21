package csvread;

/**
 * exception to throw when salary entry is invalid
 */
public class InvalidSalaryException extends CSVReadException{
    public InvalidSalaryException(String message){
        super(message);
    }
    
}
