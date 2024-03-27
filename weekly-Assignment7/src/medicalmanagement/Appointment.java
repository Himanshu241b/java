package medicalmanagement;

import java.time.LocalDateTime;

public class Appointment {
    int id;
    Patient patient;
    Doctor doctor;

    LocalDateTime dateTime;

    Appointment(int id, Patient patient,Doctor doctor, LocalDateTime dateTime) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getId() {
        return id;
    }

    public void displayAppointment(){
        System.out.println("Appointment id: "+id);
        System.out.println("Patient details: ");
        System.out.println("Patient name: "+patient.getName());
        System.out.println("Patient disease: "+patient.getDisease());
        System.out.println("Patient contact: "+patient.getContact());
        System.out.println("Doctor details:");
        System.out.println("Doctor name: "+doctor.getName());
        System.out.println("Doctor speciality: "+doctor.getSpeciality());
        System.out.println("Doctor contact: "+doctor.getContact());
        System.out.println("Appointement is fixed on: "+dateTime);
        System.out.println("*********************************");


    }
}
