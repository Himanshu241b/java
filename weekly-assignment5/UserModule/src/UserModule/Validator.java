package UserModule;//imports
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class to validate a user
 */
class Validator {
    /**
     * Method to validate a user with employee id and password
     * @param empId employee id of user
     * @param password password of user
     * @return true if user is valid
     */
    public boolean validateUser(String empId, String password) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/himanshu/Desktop/Avisoft/java/weekly-assignment5/src/database/avisoftEmployees.csv"))) {
            String line; // each line of csv file
            bufferedReader.readLine(); // skip first line with headers
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(","); // Split by comma
                try {
                    if (fields[0].equals(empId) && fields[1].equals(password))
                        return true;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException ){
                    System.out.println("Index out of bounds while reading file");
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("Database File not found");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return false;
    }
}