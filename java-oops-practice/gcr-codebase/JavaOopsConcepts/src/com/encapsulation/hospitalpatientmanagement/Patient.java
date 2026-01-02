package com.encapsulation.hospitalpatientmanagement;

public abstract class Patient {
	// Encapsulation
    private int patientId;
    private String name;
    private int age;

    // Sensitive medical data (secured)
    private String diagnosis;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Controlled access to sensitive data
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }
}
