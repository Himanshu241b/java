package adminmodule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class AdminLogin{
    public static Admin loginAdmin(String adminId, String password){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/himanshu/Desktop/Avisoft/java/weekly-assignment5/src/database/admin.csv"))) {
            String line; // each line of csv file
            bufferedReader.readLine(); // skip first line with headers
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(","); // Split by comma
                try {
                    if (fields[0].equals(adminId) && fields[1].equals(password))
                        return new Admin(adminId, fields[2], fields[3]);
                }
                catch(IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("Index out of bounds while reading file");
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("Database File not found");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}