package onlinevotingsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class to change the password of a user or admin
 */
class PasswordChanger{
    /**
     * method to change the password
     * @param employeeOrAdminId id of the employee of admin
     * @param filePathOfAdminOrVoter file path of admin or employee file in database
     */
    public static void changePassword(String employeeOrAdminId, String filePathOfAdminOrVoter){
        Scanner scanner = new Scanner(System.in);
        try {
            Path path = Paths.get(filePathOfAdminOrVoter);
            List<String> lines = Files.readAllLines(path);

            for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
                String line = lines.get(lineNumber);
                String[] parts = line.split(",");
                String newPassword;
                if (parts.length >= 4 && parts[0].equals(employeeOrAdminId)) {
                    while(true) {
                        System.out.println("Enter new Password:");
                        newPassword = scanner.next();
                        if(!checkPasswordStrength(newPassword)) {
                            System.out.println("Weak password. Reenter with numbers, special characters lower and uppercase characters and minimum length of 8.");
                            continue;
                        }
                        else
                            break;
                    }
                    System.out.println("Enter new Password again:");
                    String newPasswordAgain = scanner.next();
                    //double check the password entered by user
                    if(newPassword.equals(newPasswordAgain)) {
                        parts[1] = newPassword;
                        lines.set(lineNumber, String.join(",", parts));
                        break;
                    }
                    else{
                        System.out.println("Password doesn't match");
                        return;
                    }
                }
            }
            Files.write(path, lines);
            System.out.println("Password changed successfully.");

        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.println("File not found while registering");
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Array index out of bounds while registering");
        }
        catch(IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * method to check strength of password entered by user
     * @param newPassword new password entered by user
     * @return true if new password entered is of valid strength
     */

    public static boolean checkPasswordStrength(String newPassword){
            // Regular expression pattern for a strong password
            // Requires at least one digit, one lowercase letter, one uppercase letter,
            // one special character, and a minimum length of 8 characters
            String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

            // Compile the regular expression pattern
            Pattern pattern = Pattern.compile(passwordPattern);

            // Match the password against the pattern
            Matcher matcher = pattern.matcher(newPassword);

            return matcher.matches();
    }
}