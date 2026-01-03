package com.hospitalpatientmanagementsystem;
public class Doctor {

    private String doctorId;
    private String name;
    private String specialization;

    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Doctor: " + name +
                " | ID: " + doctorId +
                " | Specialization: " + specialization);
    }
}
