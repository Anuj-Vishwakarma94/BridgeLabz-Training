package com.objectmodeling;

import java.util.ArrayList;

public class Patient {

    String patientname;
    ArrayList<Doctor> doctorlist = new ArrayList<>();

    Patient(String patientname) {
        this.patientname = patientname;
    }

    void addDoctor(Doctor doctor) {
        doctorlist.add(doctor);
    }

    void showDoctors() {
        System.out.println(patientname + " consulted doctors:");
        for (Doctor doctor : doctorlist) {
            System.out.println(doctor.doctorname);
        }
        System.out.println();
    }
}