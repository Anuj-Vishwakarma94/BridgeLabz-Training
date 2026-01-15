package com.hospitalqueue;
public class Patient {
    String name;
    int criticality; // 1 (low) – 10 (high)

    public Patient(String name, int criticality) {
        this.name = name;
        this.criticality = criticality;
    }
}
