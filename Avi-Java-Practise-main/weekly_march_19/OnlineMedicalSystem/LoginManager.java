package OnlineMedicalSystem;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginManager {


        public static User login(String email, String password, String filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                // Skip header line
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] fields = line.split(",");
                    String userEmail = fields[0];
                    String userPassword = fields[1];
                    String userName = fields[2];

                    if (userEmail.equals(email) && userPassword.equals(password)) {
                        System.out.println("Logged In successfully");
                        if (fields.length > 3) {
                            String userType = fields[3];
                            switch (userType) {
                                case "Admin":
                                    return new Admin(userEmail, userName);
                                case "Doctor":
                                    String doctorSpecialization = fields[4]; // Assuming specialization is the fifth field
                                    return new Doctor(userEmail, userName, password, doctorSpecialization);
                                default:
                                    return new Patient(userEmail, userName);
                            }
                        }
                        return new Patient(userEmail, userName);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("File not found: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Invalid email or password");
            return null;
        }
    }

