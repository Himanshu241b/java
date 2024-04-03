package OnlineMedicalSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AppointmentScheduler {

    private static final int MAX_APPOINTMENTS_PER_DAY = 2;
    private static Map<String, List<Doctor>> doctorsByDisease = new HashMap<>();
    private static Map<String, Map<String, List<String>>> appointmentsByDoctorAndDate = new HashMap<>();

    private static Map<String, List<String>> appointmentsByPatientEmail = new HashMap<>(); // New data structure to store appointments by patient email


    // Method to read doctor data from CSV and organize them by disease
    public static void initializeDoctors(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) { // Ensure there are enough fields
                    String email = data[0].trim();
                    String name = data[2].trim();
                    String type = data[3].trim();
                    Doctor doctor = new Doctor(email, name, null, type);
                    doctorsByDisease.computeIfAbsent(type, k -> new ArrayList<>()).add(doctor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to schedule an appointment for a patient
    // Method to schedule an appointment for a patient
    public static void scheduleAppointment(Patient patient, Scanner scanner) {
        // Initialize doctors
        if (doctorsByDisease.isEmpty()) {
            initializeDoctors("G:\\java\\weeklyasignment\\OnlineMedicalSystem\\files\\doctorsLoginFile.csv");
        }

        System.out.println("Enter your disease: ");
        String disease = scanner.nextLine().trim();

        // Retrieve list of doctors for the specified disease
        List<Doctor> doctors = doctorsByDisease.getOrDefault(disease, new ArrayList<>());

        if (doctors.isEmpty()) {
            System.out.println("No doctors available for the specified disease: " + disease);
            return;
        }

        // Display the list of doctors
        System.out.println("Doctors available for " + disease + ":");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getName());
        }

        // Prompt user to choose a doctor
        System.out.println("Enter the number of the doctor you want to choose:");
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice < 1 || choice > doctors.size()) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number corresponding to the doctor.");
            return;
        }

        // Get the selected doctor
        Doctor selectedDoctor = doctors.get(choice - 1);

        // Proceed with appointment scheduling
        System.out.println("Enter desired appointment date (yyyy-MM-dd): ");
        String appointmentDateStr = scanner.nextLine().trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date appointmentDate;
        try {
            appointmentDate = dateFormat.parse(appointmentDateStr);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            return;
        }

        String appointmentDateString = dateFormat.format(appointmentDate);

        // Check availability of the selected doctor on the chosen date
        Map<String, List<String>> appointmentsByDate = appointmentsByDoctorAndDate.getOrDefault(selectedDoctor.getEmail(), new HashMap<>());
        List<String> appointments = appointmentsByDate.getOrDefault(appointmentDateString, new ArrayList<>());
        if (appointments.size() < MAX_APPOINTMENTS_PER_DAY && !appointments.contains(appointmentDateString)) {
            appointments.add(appointmentDateString);
            appointmentsByDate.put(appointmentDateString, appointments);
            appointmentsByDoctorAndDate.put(selectedDoctor.getEmail(), appointmentsByDate);

            String appointmentInfo = patient.getEmail() + "," + selectedDoctor.getEmail() + "," + appointmentDateString;
            appointmentsByPatientEmail.computeIfAbsent(patient.getEmail(), k -> new ArrayList<>()).add(appointmentInfo);

            // Appointment scheduled successfully
            System.out.println("Appointment scheduled successfully:");
            System.out.println("Patient: " + patient.getName());
            System.out.println("Doctor: " + selectedDoctor.getName());
            System.out.println("Disease: " + disease);
            System.out.println("Appointment Date: " + appointmentDateString);
        } else {
            // Doctor not available on the chosen date
            System.out.println("Selected doctor is not available on " + appointmentDateString + ". Please choose another date.");
        }
    }




    public static void showPatientAppointments(Patient patient) {
        // Retrieve appointments for the given patient email
        List<String> patientAppointments = appointmentsByPatientEmail.getOrDefault(patient.getEmail(), new ArrayList<>());

        if (patientAppointments.isEmpty()) {
            System.out.println("No appointments found for " + patient.getName());
            return;
        }

        System.out.println("Appointments for " + patient.getName() + ":");
        for (String appointment : patientAppointments) {
            String[] appointmentInfo = appointment.split(",");
            String patientEmail = appointmentInfo[0].trim();
            String doctorEmail = appointmentInfo[1].trim();
            String appointmentDateStr = appointmentInfo[2].trim();

            // Get doctor details using doctor email
            Doctor doctor = getDoctorByEmail(doctorEmail);

            System.out.println("Doctor: " + doctor.getName());
            System.out.println("Disease: " + doctor.getType());
            System.out.println("Appointment Date: " + appointmentDateStr);
            System.out.println();
        }
    }

    private static Doctor getDoctorByEmail(String email) {
        for (List<Doctor> doctors : doctorsByDisease.values()) {
            for (Doctor doctor : doctors) {
                if (doctor.getEmail().equals(email)) {
                    return doctor;
                }
            }
        }
        return null; // Return null if no doctor found with the specified email
    }




    public static void showDoctorAppointments(Doctor doctor) {
        // Retrieve appointments for the given doctor email
        List<String> doctorAppointments = new ArrayList<>();
        Map<String, List<String>> appointmentsByDate = appointmentsByDoctorAndDate.getOrDefault(doctor.getEmail(), new HashMap<>());
        for (List<String> appointments : appointmentsByDate.values()) {
            doctorAppointments.addAll(appointments);
        }

        if (doctorAppointments.isEmpty()) {
            System.out.println("No appointments found for " + doctor.getName());
            return;
        }

        System.out.println("Appointments for " + doctor.getName() + ":");
        for (String appointment : doctorAppointments) {
            String[] appointmentInfo = appointment.split(",");
            String patientEmail = appointmentInfo[0].trim();
            String appointmentDateStr = appointmentInfo[2].trim();

            // Get patient details using patient email
            Patient patient = getPatientByEmail(patientEmail);

            System.out.println("Patient: " + patient.getName());
            System.out.println("Appointment Date: " + appointmentDateStr);
            System.out.println();
        }
    }


    private static Patient getPatientByEmail(String email) {
        for (Map.Entry<String, List<String>> entry : appointmentsByPatientEmail.entrySet()) {
            String patientEmail = entry.getKey();
            if (patientEmail.equals(email)) {
                // Retrieve patient details using email
                List<String> appointments = entry.getValue();
                if (!appointments.isEmpty()) {
                    // For simplicity, let's assume the patient's name is stored in the first appointment info
                    String[] appointmentInfo = appointments.get(0).split(",");
                    String patientName = appointmentInfo[1].trim(); // Assuming patient name is the second field
                    return new Patient(email, patientName);
                }
            }
        }
        return null; // Return null if no patient found with the specified email
    }



}