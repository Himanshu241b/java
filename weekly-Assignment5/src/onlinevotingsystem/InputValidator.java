package onlinevotingsystem;

import java.util.regex.Pattern;

public class InputValidator {
        public static boolean isValidName(String name) {
            // Regular expression pattern for a name
            // Allows alphabets, spaces, hyphens, and apostrophes
            String namePattern = "^[a-zA-Z]+$";

            // Compile the regular expression pattern
            Pattern pattern = Pattern.compile(namePattern);

            // Match the name against the pattern
            return pattern.matcher(name).matches();
        }


    public static boolean isValidDate(String date) {
        // Regular expression pattern for a date in dd/mm/yyyy format
        // Ensures valid days, months, and years
        String datePattern = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(datePattern);

        // Match the date against the pattern
        return pattern.matcher(date).matches();
    }
}
