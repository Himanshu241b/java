package UserModule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
class PasswordChanger{
    public static void changePassword(String employeeId){
        Scanner scanner = new Scanner(System.in);
        try {
            Path path = Paths.get("/home/himanshu/Desktop/Avisoft/java/weekly-assignment5/src/database/avisoftEmployees.csv");
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equals(employeeId)) {
                    System.out.println("Enter new Password:");
                    String newPassword = scanner.next();
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
}