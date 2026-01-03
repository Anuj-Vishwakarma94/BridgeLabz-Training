package com.hospitalpatientmanagementsystem;
public abstract class Patient {

    private String patientId;
    private String name;
    private int age;
    protected boolean isEmergency;

    // Normal Admission Constructor
    public Patient(String patientId, String name, int age, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.isEmergency = false;
    }

    // Emergency Admission Constructor (Overloaded)
    public Patient(String patientId, String name, int age, String medicalHistory, boolean isEmergency) {
        this(patientId, name, age, medicalHistory);
        this.isEmergency = isEmergency;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Encapsulation — controlled access to medical data
    public String getSummary() {
        return "PatientID: " + patientId +
               ", Name: " + name +
               ", Age: " + age +
               ", Emergency: " + (isEmergency ? "YES" : "NO");
    }

    // Polymorphism — subclasses override this
    public abstract void displayInfo();
}
