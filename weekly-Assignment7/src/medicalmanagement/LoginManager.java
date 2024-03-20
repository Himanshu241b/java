package medicalmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LoginManager {
    public static User login(String studentEmail, String password, String emailAtGoogleCsvFilePath){
            //read the database file
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(emailAtGoogleCsvFilePath))) {
                String line; // each line of csv file
                bufferedReader.readLine(); // skip first line with headers
                while ((line = bufferedReader.readLine()) != null) {
                    String[] fields = line.split(","); // Split by comma
                    try {
                        if (fields[0].equals(studentEmail) && fields[1].equals(password)) {
                            System.out.println("Logged In successfully");
                            return new User(fields[0], fields[2]);
                        }

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
            catch (Exception exception){
                exception.printStackTrace();
            }
        System.out.println("Account not found.");
            return null;
        }
    }

