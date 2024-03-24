package medicalmanagement;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        }

