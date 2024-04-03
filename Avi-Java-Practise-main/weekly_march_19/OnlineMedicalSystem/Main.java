package OnlineMedicalSystem;


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        final String patientLoginFilePath = "G:\\java\\weeklyasignment\\OnlineMedicalSystem\\files\\patientsLoginFile.csv";
        final String adminLoginFilePath = "G:\\java\\weeklyasignment\\OnlineMedicalSystem\\files\\adminLoginFile.csv";
        final String doctorLoginFilePath = "G:\\java\\weeklyasignment\\OnlineMedicalSystem\\files\\doctorsLoginFile.csv";

        Patient patient = null;
        User admin = null;
        User user = null;
        do{
            System.out.println("Press 1: To continue as a patient.");
            System.out.println("Press 2: To continue as an admin");
            System.out.println("Press 3: To continue as a doctor");
            System.out.println("Press 0: To exit...");

            char choice = scanner.next().charAt(0);

            switch(choice){
                case '1': //
                    do {
                        System.out.println("Press 1: To login.");

                        System.out.println("Press 0: Back to Main Menu");

                        char patientChoice = scanner.next().charAt(0);
                        switch(patientChoice){
                            case '1': // patient login
                                if(patient == null) {
                                    String PatientEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        PatientEmail = scanner.next();
                                        if (InputValidator.validateEmail(PatientEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your password");
                                    String password = scanner.next();
                                   patient = (Patient) LoginManager.login(PatientEmail, password, patientLoginFilePath);

                                    if (patient != null) {


                                        do {
                                            System.out.println("Options");
                                            System.out.println("1: Schedule Appointment");
                                            System.out.println("2: View Appointments");
                                            System.out.println("0: Logout");

                                            char PatientChoiceOperation = scanner.next().charAt(0);
                                            scanner.nextLine();

                                            switch (PatientChoiceOperation) {


                                                case '1':
                                                    AppointmentScheduler.scheduleAppointment(patient,scanner);
                                                    patient=null;
                                                    break;

                                                case '2':
                                                    AppointmentScheduler.showPatientAppointments(patient);
                                                    patient=null;
                                                    break;

                                                case '0':
                                                    patient=null;
                                                    break;

                                                default:
                                                    System.out.println("Please Enter a Valid Choice");


                                            }
                                        } while (patient != null);


                                    }
                                    break;
                                }
                                else
                                    System.out.println("Already logged in. Logout First.");
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

                        System.out.println("Press 0: Back to Main Menu");

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
                                    admin =  LoginManager.login(studentEmail, password, adminLoginFilePath);
                                    if(admin!=null) {
                                        do {
                                            System.out.println("Options");
                                            System.out.println("1: Add User");
                                            System.out.println("2: Delete User");
                                            System.out.println("3: View Appointments");
                                            System.out.println("4: Manage Appointments");
                                            System.out.println("0: Logout");

                                            char adminChoiceOperation=scanner.next().charAt(0);

                                            switch (adminChoiceOperation){

                                                case '1':
                                                    boolean checkAdd=false;
                                                    do {
                                                        System.out.println("Options");
                                                        System.out.println("1: Patient");
                                                        System.out.println("2: Doctor");
                                                        System.out.println("3: Back");

                                                        char adminAddChoice=scanner.next().charAt(0);



                                                        switch ( adminAddChoice){


                                                            case '1':
                                                                  checkAdd=Admin.addPatient(patientLoginFilePath,scanner);
                                                                 if( checkAdd)
                                                                     break;

                                                                 break;

                                                            case '2':
                                                                 checkAdd=Admin.addDoctor(doctorLoginFilePath,scanner);
                                                                if( checkAdd)
                                                                    break;
                                                                break;

                                                            case '3':
                                                                 checkAdd=true;
                                                                break;


                                                            default:
                                                                System.out.println("Enter a Valid Choice");


                                                        }
                                                    }while(! checkAdd);

                                                    break;

                                                case '2':
                                                    boolean checkDelete=false;
                                                    do {
                                                        System.out.println("Delete Options ");
                                                        System.out.println("1: Patient");
                                                        System.out.println("2: Doctor");
                                                        System.out.println("3: Back");

                                                        char adminAddChoice=scanner.next().charAt(0);



                                                        switch ( adminAddChoice){


                                                            case '1':
                                                                 checkDelete=Admin.deletePatient(patientLoginFilePath,scanner);
                                                                if( checkDelete)
                                                                    break;

                                                                break;

                                                            case '2':
                                                                 checkDelete=Admin.deleteDoctor(doctorLoginFilePath,scanner);
                                                                if( checkDelete)
                                                                    break;
                                                                break;

                                                            case '3':
                                                                 checkDelete=true;
                                                                break;


                                                            default:
                                                                System.out.println("Enter a Valid Choice");


                                                        }
                                                    }while(! checkDelete);

                                                    break;



                                                case '3':
                                                    System.out.println();

                                                    case '0': // admin logout
                                                    admin = null;
                                                    break;
                                                default:
                                                    System.out.println("Enter valid choice");


                                            }

                                        }while(admin !=null);
                                    }
                                }else
                                    System.out.println("Already logged in. Logout First.");
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

                        System.out.println("Press 0: Back to Main Menu.");
                        char doctorChoice = scanner.next().charAt(0);
                        switch(doctorChoice) {
                            case '1': // doctor login
                                if(user == null) {
                                    String doctorEmail;
                                    System.out.println("Enter your email: ");
                                    while (true) {
                                        doctorEmail = scanner.next();
                                        if (InputValidator.validateEmail(doctorEmail)) {
                                            break;
                                        }
                                        System.out.println("Enter valid email:");
                                    }
                                    System.out.println("Enter your Password");
                                    String doctorPassword = scanner.next();
                                    user = LoginManager.login(doctorEmail, doctorPassword, doctorLoginFilePath);

                                    if(user!=null) {
                                        do {
                                            System.out.println("Options");
                                            System.out.println("1: View Appointments");
                                            System.out.println("0: Logout");

                                            char doctorChoiceOperation = scanner.next().charAt(0);

                                            switch (doctorChoiceOperation)
                                            {
                                                case '1':

                                                    if(user instanceof Doctor) {
                                                        Doctor doctor = (Doctor) user;
                                                        // Show doctor appointments
                                                        AppointmentScheduler.showDoctorAppointments(doctor);
                                                    } else {
                                                        System.out.println("Invalid doctor credentials.");
                                                    }
                                                    break;

                                                case '0':
                                                    user=null;
                                                    break;

                                                default:
                                                    System.out.println("Please Enter a Valid Input");
                                            }

                                        } while (user != null);
                                    }

                                }else
                                    System.out.println("Already logged in. Logout First.");
                                break;

                            case '0': // doctor logout
                                user = null;
                                break;
                            default:
                                System.out.println("Enter valid choice");
                        }
                    }while(user != null);
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
