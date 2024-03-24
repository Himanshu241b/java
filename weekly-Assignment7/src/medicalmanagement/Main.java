package medicalmanagement;

//imports
import com.sun.source.util.TaskListener;

import java.awt.datatransfer.StringSelection;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final String patientLoginFilePath = "/home/himanshu/Desktop/Avisoft/java/weekly-Assignment7/src/database/patientsLoginFile.csv";
        final String adminLoginFilePath = "/home/himanshu/Desktop/Avisoft/java/weekly-Assignment7/src/database/adminLoginFile.csv";
        final String doctorLoginFilePath = "/home/himanshu/Desktop/Avisoft/java/weekly-Assignment7/src/database/doctorsLoginFile.csv";User patient = null;
        User admin = null;
        User doctor = null;
        do{
            System.out.println("Press 1: To continue as a patient.");
            System.out.println("Press 2: To continue as an admin");
            System.out.println("Press 3: To continue as a doctor");
            System.out.println("Press 0: To exit...");

            char choice = scanner.next().charAt(0);

            switch(choice){
                case '1': // Student interface
                    do {
                        System.out.println("Press 1: To login.");
                        System.out.println("Press 2: To display doctors details.");
                        System.out.println("Press 0: To logout.");

                        char patientChoice = scanner.next().charAt(0);
                        switch(patientChoice){
                            case '1': // patient login
                                if(patient == null) {
                                    String studentEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        studentEmail = scanner.next();
                                        if (InputValidator.validateEmail(studentEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your password");
                                    String password = scanner.next();
                                    patient = LoginManager.loginPatient(studentEmail, password, patientLoginFilePath);
                                }else
                                    System.out.println("Already logged in. Logout First.");
                                break;
                            case '2': // display doctors list
                                if(patient == null) {
                                    System.out.println("Login first.");
                                    break;
                                }
                                Admin.displayDoctors(doctorLoginFilePath);
                                break;
                            case '0': // patient logout
                                patient = null;
                                break;
                            default:
                                System.out.println("Enter valid input");
                        }
                    }
                    while(patient != null);
                    break;
                case '2': // admin interface
                    do{
                        System.out.println("Press 1: To login.");
                        System.out.println("Press 2: To add a patient.");
                        System.out.println("Press 3: To add a doctor.");
                        System.out.println("Press 4: To delete a patient.");
                        System.out.println("Press 5: To delete a doctor");
                        System.out.println("Press 0: To log out.");

                        char adminChoice = scanner.next().charAt(0);

                        switch (adminChoice){
                            case '1': // admin login
                                if(admin == null){
                                    String studentEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        studentEmail = scanner.next();
                                        if (InputValidator.validateEmail(studentEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your password");
                                    String password = scanner.next();
                                    admin = LoginManager.loginAdmin(studentEmail, password, adminLoginFilePath);
                                }else
                                    System.out.println("Already logged in. Logout First.");
                                break;
                            case '2': // add a patient
                                    if(admin == null) {
                                        System.out.println("Login first.");
                                        break;
                                    }
                                    Admin.registerPatient(patientLoginFilePath);
                                break;
                            case '3': // add a doctor
                                if(admin == null) {
                                    System.out.println("Login first.");
                                    break;
                                }
                                Admin.registerDoctor(doctorLoginFilePath);
                                break;
                            case '4': // delete a patient
                                Admin.deletePatient(patientLoginFilePath);
                                break;
                            case '5': // delete a doctor
                                Admin.deleteDoctor(doctorLoginFilePath);
                                break;
                            case '0': // admin logout
                                admin = null;
                                break;
                            default:
                                System.out.println("Enter valid choice");
                        }
                    }while(admin != null);
                    break;
                case '3': // doctor interface
                    do {
                        System.out.println("Press 1: To login.");
                        System.out.println("Press 0: To logout.");
                        char doctorChoice = scanner.next().charAt(0);
                        switch(doctorChoice) {
                            case '1': // doctor login
                                if(doctor == null) {
                                    String doctorEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        doctorEmail = scanner.next();
                                        if (InputValidator.validateEmail(doctorEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your doctorPassword");
                                    String doctorPassword = scanner.next();
                                    doctor = LoginManager.loginDoctor(doctorEmail, doctorPassword, doctorLoginFilePath);
                                }else
                                    System.out.println("Already logged in. Logout First.");
                                break;
                            case '0': // doctor logout
                                doctor = null;
                                break;
                            default:
                                System.out.println("Enter valid choice");
                        }
                    }while(doctor != null);
                    break;
                case '0':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice.");
            }
        }while(true);
    }
}