package OnlineMedicalSystem;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin extends User {



    public Admin(String email, String name) {
        super(email, name);

    }

    String Password;

    public String getPassword() {
        return Password;
    }

    public static boolean addPatient(String filePath , Scanner scanner) {


        System.out.println("Enter patient's email: ");
        String patientEmail;
        while (true) {
            patientEmail = scanner.next();
            if (InputValidator.validateEmail(patientEmail)) {
                break;
            }
            System.out.println("Enter valid email:");
        }

        // Check if patient email already exists in the file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(patientEmail)) {
                    System.out.println("Patient with this email already exists!");
                    return false; // Return false indicating addition failed
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false; // Return false indicating addition failed
        }

        System.out.println("Enter patient's password: ");
        String patientPassword = scanner.next();

        System.out.println("Enter patient's name: ");
        String patientName = scanner.next();

       ;

        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(patientEmail + "," + patientPassword + "," + patientName ); // Add '\n' to end the line
            System.out.println("Patient added successfully!");
            return true; // Return true indicating successful addition
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false; // Return false indicating addition failed
        }
    }



    public  static boolean addDoctor(String filePath, Scanner scanner) {


        System.out.println("Enter doctor's email: ");
        String doctorEmail;
        while (true) {
            doctorEmail = scanner.next();
            if (InputValidator.validateEmail(doctorEmail)) {
                break;
            }
            System.out.println("Enter valid email:");
        }

        // Check if doctor email already exists in the file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].equals(doctorEmail)) {
                    System.out.println("Doctor with this email already exists!");
                    return false; // Return false indicating addition failed
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false; // Return false indicating addition failed
        }

        System.out.println("Enter doctor's password: ");
        String doctorPassword = scanner.next();

        System.out.println("Enter doctor's name: ");
        String doctorName = scanner.next();

        System.out.println("Enter Doctor Specialties");
        String doctorSpecialities=scanner.next();

        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(doctorEmail + "," + doctorPassword + "," + doctorName +","+doctorSpecialities); // Add '\n' to end the line
            System.out.println("Doctor added successfully!");
            return true; // Return true indicating successful addition
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false; // Return false indicating addition failed
        }
    }




    public static boolean deletePatient(String filePath, Scanner scanner) {

        System.out.println("Enter patient's email to delete: ");
        String patientEmail;
        while (true) {
            patientEmail = scanner.next();
            if (InputValidator.validateEmail(patientEmail)) {
                break;
            }
            System.out.println("Enter valid email:");
        }

        return deleteUser(patientEmail, filePath, true);
    }

    public static boolean deleteDoctor(String filePath,Scanner scanner) {


        System.out.println("Enter doctor's email to delete: ");
        String doctorEmail;
        while (true) {
            doctorEmail = scanner.next();
            if (InputValidator.validateEmail(doctorEmail)) {
                break;
            }
            System.out.println("Enter valid email:");
        }

        return deleteUser(doctorEmail, filePath, false);
    }

    private static boolean  deleteUser(String email, String filePath, boolean isPatient) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean found = false;

            while ((currentLine = reader.readLine()) != null) {
                String[] fields = currentLine.split(",");
                if (fields.length > 0 && fields[0].equals(email) && (isPatient ? fields.length >= 3 : fields.length >= 4)) {
                    found = true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (!found) {
                System.out.println((isPatient ? "Patient" : "Doctor") + " with email " + email + " not found.");
                return false;
            }

            if (!inputFile.delete()) {
                System.out.println("Could not delete original file.");
                return false;
            }

            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename temp file.");
                return false;
            }

            System.out.println((isPatient ? "Patient" : "Doctor") + " deleted successfully.");
            return true;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false;
        }
    }



}
