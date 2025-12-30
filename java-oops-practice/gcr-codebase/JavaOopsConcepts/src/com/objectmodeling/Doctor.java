package com.objectmodeling;
import java.util.ArrayList;
public class Doctor {
	String doctorname;
    ArrayList<Patient> patientlist = new ArrayList<>();

    Doctor(String doctorname) {
        this.doctorname = doctorname;
    }

    void consult(Patient patient) {
        patientlist.add(patient);
        patient.addDoctor(this);
        System.out.println("Doctor " + doctorname + " consulted patient " + patient.patientname);
    }

    void showPatients() {
        System.out.println("Patients of Dr. " + doctorname + ":");
        for (Patient patient : patientlist) {
            System.out.println(patient.patientname);
        }
        System.out.println();
    }
}
