package medicalmanagement;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Admin {
    static Scanner scanner = new Scanner(System.in);
    public static void registerPatient(String patientsLoginFilePath) {
        System.out.println("Enter Patient email:");
        String patientEmail;
        while (true) {
            patientEmail = scanner.next();
            if (InputValidator.validateEmail(patientEmail)) {
                break;
            }
            System.out.println("Enter valid email:");
        }
            scanner.nextLine();
            System.out.println("Enter patient name:");
            String patientName = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Set patient password:");
            String patientPassword = scanner.next();
            System.out.println("Enter patient's illness(disease): ");
            String patientDisease = scanner.next();
            System.out.println("Enter your contact number:");
            String contactNumber = scanner.next();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(patientsLoginFilePath, true))) {
                String newPatientRow = patientEmail + "," + patientPassword + "," + patientName + "," + patientDisease+","+contactNumber;
                bufferedWriter.write(newPatientRow);
                bufferedWriter.newLine();
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("The database file not found.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("Patient added successfully");
        }


        public static void registerDoctor (String doctorLoginFilePath){
            System.out.println("Enter doctor email:");
            String doctorEmail;
            while (true) {
                doctorEmail = scanner.next();
                if (InputValidator.validateEmail(doctorEmail)) {
                    break;
                }
                System.out.println("Enter valid email:");

            }
                scanner.nextLine();
                System.out.println("Enter doctor name:");
                String doctorName = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Set doctor password:");
                String doctorPassword = scanner.next();
                System.out.println("Enter doctor's speciality");
                String doctorSpeciality = scanner.next();
                System.out.println("Enter your contact number:");
                String contactNumber = scanner.next();
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(doctorLoginFilePath, true))) {
                    String newDoctorRow = doctorEmail + "," + doctorPassword + "," + doctorName + "," + doctorSpeciality+","+contactNumber;
                    bufferedWriter.write(newDoctorRow);
                    bufferedWriter.newLine();
                } catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("The database file not found.");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("Doctor added successfully.");
            }

            public static void deletePatient(String patientLoginFilePath){
                System.out.println("Enter email of patient to delete:");
                String emailToDelete;
                while (true) {
                    emailToDelete = scanner.next();
                    if (InputValidator.validateEmail(emailToDelete)) {
                        break;
                    }
                    System.out.println("Enter valid email:");
                }
                boolean isDeleted = false;
                StringBuilder updatedFileContent = new StringBuilder();
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(patientLoginFilePath))){

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if(parts[0].equals(emailToDelete))
                            isDeleted = true;
                        if (!parts[0].equals(emailToDelete)) {
                            updatedFileContent.append(line);
                            updatedFileContent.append("\n");
                        }
                    }
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(patientLoginFilePath))){
                    bufferedWriter.write(updatedFileContent.toString());
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                if(isDeleted)
                    System.out.println("Patient deleted successfully");
                else
                    System.out.println("Patient not found.");
            }

            public static void deleteDoctor(String doctorLoginFilePath){
                System.out.println("Enter email of doctor to delete:");
                String emailToDelete;
                while (true) {
                    emailToDelete = scanner.next();
                    if (InputValidator.validateEmail(emailToDelete)) {
                        break;
                    }
                    System.out.println("Enter valid email:");
                }
                boolean isDeleted = false;
                StringBuilder updatedFileContent = new StringBuilder();
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(doctorLoginFilePath))){

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if(parts[0].equals(emailToDelete))
                            isDeleted = true;
                        if (!parts[0].equals(emailToDelete)) {
                            updatedFileContent.append(line);
                            updatedFileContent.append("\n");
                        }
                    }
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(doctorLoginFilePath))){
                    bufferedWriter.write(updatedFileContent.toString());
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                if(isDeleted)
                    System.out.println("Doctor deleted successfully");
                else
                    System.out.println("Doctor not found.");
            }

            public static void updatePatient(String patientLoginFilePath){
                System.out.println("Enter email of patient to delete:");
                String emailToDelete;
                while (true) {
                    emailToDelete = scanner.next();
                    if (InputValidator.validateEmail(emailToDelete)) {
                        break;
                    }
                    System.out.println("Enter valid email:");
                }
                boolean isDeleted = false;
                StringBuilder updatedFileContent = new StringBuilder();
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(patientLoginFilePath))){

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(",");

                        if (!parts[0].equals(emailToDelete)) {
                            updatedFileContent.append(line);
                            updatedFileContent.append("\n");
                        }
                        else{
                            System.out.println("Enter new email:");
                            String emailToUpdate;
                            while (true) {
                                emailToUpdate = scanner.next();
                                if (InputValidator.validateEmail(emailToUpdate)) {
                                    break;
                                }
                                System.out.println("Enter valid email:");
                            }
                            System.out.println("Enter new password:");
                            String passwordToUpdate = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter new Name:");
                            String nameToUpdate = scanner.nextLine();
                            scanner.nextLine();
                            System.out.println("Enter the disease:");
                            String diseaseToUpdate = scanner.next();
                            System.out.println("Enter new contact number");
                            String contactNumberToUpdate = scanner.next();
                            String updatedRow = emailToUpdate+","+passwordToUpdate+","+nameToUpdate+","+diseaseToUpdate+","+contactNumberToUpdate;
                            updatedFileContent.append((updatedRow));
                            updatedFileContent.append("\n");
                            isDeleted = true;
                        }
                    }
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(patientLoginFilePath))){
                    bufferedWriter.write(updatedFileContent.toString());
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                if(isDeleted)
                    System.out.println("Patient updated successfully");
                else
                    System.out.println("Patient not found.");
            }

            public static void updateDoctor(String doctorLoginFilePath){
                System.out.println("Enter email of doctor to delete:");
                String emailToDelete;
                while (true) {
                    emailToDelete = scanner.next();
                    if (InputValidator.validateEmail(emailToDelete)) {
                        break;
                    }
                    System.out.println("Enter valid email:");
                }
                boolean isDeleted = false;
                StringBuilder updatedFileContent = new StringBuilder();
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(doctorLoginFilePath))){

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(",");

                        if (!parts[0].equals(emailToDelete)) {
                            updatedFileContent.append(line);
                            updatedFileContent.append("\n");
                        }
                        else{
                            System.out.println("Enter new email:");
                            String emailToUpdate;
                            while (true) {
                                emailToUpdate = scanner.next();
                                if (InputValidator.validateEmail(emailToUpdate)) {
                                    break;
                                }
                                System.out.println("Enter valid email:");
                            }

                            System.out.println("Enter new password:");
                            String passwordToUpdate = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter new Name:");
                            String nameToUpdate = scanner.nextLine();
                            scanner.nextLine();
                            System.out.println("Enter the speciality:");
                            String specialityToUpdate = scanner.next();
                            System.out.println("Enter new contact number");
                            String contactNumberToUpdate = scanner.next();
                            String updatedRow = emailToUpdate+","+passwordToUpdate+","+nameToUpdate+","+specialityToUpdate+","+contactNumberToUpdate;
                            updatedFileContent.append((updatedRow));
                            updatedFileContent.append("\n");
                            isDeleted = true;
                        }
                    }
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(doctorLoginFilePath))){
                    bufferedWriter.write(updatedFileContent.toString());
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                if(isDeleted)
                    System.out.println("Doctor updated successfully");
                else
                    System.out.println("Doctor not found.");
            }

            public static void displayDoctors(String doctorsLoginFilePath){
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(doctorsLoginFilePath))){
                    bufferedReader.readLine();
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        String parts[] = line.split(",");
                        System.out.println("Doctor email: " + parts[0]);
                        System.out.println("Doctor name: " + parts[2]);
                        System.out.println("Doctor speciality: " + parts[3]);
                        System.out.println("Doctor contact: " + parts[4]);
                        System.out.println("***************************");
                    }
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
                    arrayIndexOutOfBoundsException.printStackTrace();
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("Database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
            }

            public static Appointment fixAppointment(int appointmentId, Patient patient, String doctorLoginFilePath){
                System.out.println("Enter doctor's email you want to fix appointment with:");
                String doctorEmail = scanner.next();
                Doctor appointedDoctor = null;
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(doctorLoginFilePath))){

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if(parts[0].equals(doctorEmail)){
                            appointedDoctor = new Doctor(parts[0], parts[2], parts[3], parts[4]);
                        }
                    }
                }
                catch(FileNotFoundException fileNotFoundException){
                    System.out.println("database file not found.");
                }
                catch(IOException ioException){
                    ioException.printStackTrace();
                }
                if(appointedDoctor == null){
                    System.out.println("No doctor found with provided email.");
                    return null;
                }
                else{
                    System.out.println("Enter a date-time in format(yyyy-MM-dd-hh-mm)");
                    String inputDateTime;
                    while(true){
                        inputDateTime = scanner.next();
                        if(InputValidator.validateDateTimeFormat(inputDateTime))
                            break;
                        System.out.println("Enter a date-time in correct format (yyyy-MM-dd-hh-mm)");
                    }
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
                    LocalDateTime appointedDateTime = LocalDateTime.parse(inputDateTime, formatter);                    System.out.println("Appointment fixed successfully");
                    return new Appointment(appointmentId, patient, appointedDoctor, appointedDateTime);
                }
            }

            public static void cancelAppointment(List<Appointment> appointmentList){
                System.out.println("Enter id of Appointement to cancel.");
                int cancelId = 0;
                try {
                    cancelId = scanner.nextInt();
                }
                catch (InputMismatchException inputMismatchException) {
                    System.out.println("Please enter an integer id.");
                }
                for(Appointment appointmentsInList : appointmentList){
                    if(appointmentsInList.getId() == cancelId){
                        appointmentList.remove(appointmentsInList);
                        System.out.println("Appointment cancelled successfully.");
                        return;
                    }
                }
                System.out.println("Could not found the appointment.");
            }
        }

