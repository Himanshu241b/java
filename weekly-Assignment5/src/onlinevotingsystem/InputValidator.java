package onlinevotingsystem;
//imports
import java.util.regex.Pattern;

/**
 * class to validate the inputs entered by user
 */

public class InputValidator {
    /**
     * method to validate name entered by user
     * @param name the name entered by user
     * @return  true if the name is valid
     */
    public static boolean isValidName(String name) {
            // Regular expression pattern for a name
            //only allows characters
            String namePattern = "^[a-zA-Z]+$";

            // Compile the regular expression pattern
            Pattern pattern = Pattern.compile(namePattern);

            // Match the name against the pattern
            return pattern.matcher(name).matches();
        }

    /**
     * method to validate dateOfBirth entered by user
     * @param dateOfBirth dateOfBirth entered by user
     * @return true if the date is valid
     */

    public static boolean isValidDate(String dateOfBirth) {
        // Regular expression pattern for a dateOfBirth in dd/mm/yyyy format
        // Ensures valid days, months, and years
        String datePattern = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(datePattern);

        // Match the dateOfBirth against the pattern
        return pattern.matcher(dateOfBirth).matches();
    }
}
