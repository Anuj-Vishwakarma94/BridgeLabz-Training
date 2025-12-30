package com.objectmodeling;
import java.util.ArrayList;
import java.util.Scanner;

public  class Hospital {

    String hospitalname;
    ArrayList<Doctor> doctorlist = new ArrayList<>();
    ArrayList<Patient> patientlist = new ArrayList<>();

    Hospital(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    void addDoctor(Doctor doctor) {
        doctorlist.add(doctor);
    }

    void addPatient(Patient patient) {
        patientlist.add(patient);
    }

    void showHospitalDetails() {
        System.out.println("Hospital: " + hospitalname);

        System.out.println("Doctors:");
        for (Doctor doctor : doctorlist) {
            System.out.println(doctor.doctorname);
        }

        System.out.println("Patients:");
        for (Patient patient : patientlist) {
            System.out.println(patient.patientname);
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hospital hospital = new Hospital("Bhopal Hospital");

        Doctor doctor1 = new Doctor("Dr. Mehta");
        Doctor doctor2 = new Doctor("Dr. Singh");

        Patient patient1 = new Patient("Aryan");
        Patient patient2 = new Patient("Raj");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.consult(patient1);
        doctor1.consult(patient2);

        doctor2.consult(patient1);

        hospital.showHospitalDetails();

        doctor1.showPatients();
        doctor2.showPatients();

        patient1.showDoctors();
        patient2.showDoctors();
        sc.close();
    }
}
