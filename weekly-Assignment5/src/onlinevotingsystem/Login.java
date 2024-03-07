package onlinevotingsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Login {
    public static User loginUser(String employeeOrAdminId, String password, String filePathOfAdminOrUser){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathOfAdminOrUser))) {
            String line; // each line of csv file
            bufferedReader.readLine(); // skip first line with headers
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(","); // Split by comma
                try {
                    if (fields[0].equals(employeeOrAdminId) && fields[1].equals(password))
                        if(employeeOrAdminId.substring(0,2).equals("AS")) {
                            System.out.println("Logged In successfully");
                            return new Voter(employeeOrAdminId, fields[2], fields[3], fields[4].equals("true") ? true : false);
                        }
                        else {
                            System.out.println("Logged In successfully");
                            return new Admin(employeeOrAdminId, fields[2], fields[3], fields[4]);
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
        System.out.println("Login failed with wrong credentials");
        return null;
    }
    }
