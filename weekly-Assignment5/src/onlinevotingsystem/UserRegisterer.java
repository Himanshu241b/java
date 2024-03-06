package onlinevotingsystem;//imports

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class UserRegisterer{

    /**
     * Method to register a user in csv database
     * @param name name of the user
     * @param dateOfBirth dateOfBirth of the user
     */
    public static User registerUser(String name, String dateOfBirth, String employeeId){
        try {
            Path path = Paths.get("/home/himanshu/Desktop/Avisoft/java/weekly-assignment5/src/database/avisoftEmployees.csv");
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equals(employeeId)) {
                    parts[2] = name;
                    parts[3] = dateOfBirth;
                    lines.set(i, String.join(",", parts));
                    break;
                }
            }
            Files.write(path, lines);
            System.out.println(name +" is registered successfully.");
            return new User(employeeId, name, dateOfBirth);
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
       return null;
    }
}
