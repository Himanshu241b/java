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

class PasswordChanger{
    public static void changePassword(String employeeId, String filePathOfAdminOrVoter){
        Scanner scanner = new Scanner(System.in);
        try {
            Path path = Paths.get(filePathOfAdminOrVoter);
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                String newPassword;
                if (parts.length >= 4 && parts[0].equals(employeeId)) {
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
                    if(newPassword.equals(newPasswordAgain)) {
                        parts[1] = newPassword;
                        lines.set(i, String.join(",", parts));
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

    public static boolean checkPasswordStrength(String newPassword){
            // Regular expression pattern for a strong password
            // Requires at least one digit, one lowercase letter, one uppercase letter,
            // one special character, and a minimum length of 8 characters
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

            // Compile the regular expression pattern
            Pattern pattern = Pattern.compile(regex);

            // Match the password against the pattern
            Matcher matcher = pattern.matcher(newPassword);

            return matcher.matches();
    }
}