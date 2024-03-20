package medicalmanagement;

//imports

import java.util.regex.Pattern;

public class InputValidator {

    public static boolean validateDateTimeFormat(String inputDate){
        String dateFormatRegex = "^\\d{4}-(0[1-9]|1[0-2])-([0-2][0-9]|3[01])-([01][0-9]|2[0-3])-([0-5][0-9])$";

        // Check if the input string matches the regex pattern
        if (!inputDate.matches(dateFormatRegex)) {
            return false; // If the format doesn't match, return false
        }

        // Additional checks to verify the validity of the date
        // You can add more checks here if necessary (e.g., leap year)

        return true;
    }
    public static boolean validateEmail(String email){
        // regular expression pattern for emails validation
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(emailPattern);

        // Match the name against the pattern
        return pattern.matcher(email).matches();
    }
}
