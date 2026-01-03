package com.hospitalpatientmanagementsystem;
public class HospitalSystem {

    public static void main(String[] args) {

        Doctor d1 = new Doctor("D101", "Dr. Kavita", "Cardiologist");
        d1.displayInfo();

        // Create patients
        InPatient p1 = new InPatient(
                "P001", "Andrew", 45,
                "BP & Diabetes",
                4, 2500,
                false
        );

        OutPatient p2 = new OutPatient(
                "P002", "Aarush", 29,
                "Migraine",
                800,
                true
        );

        // Polymorphism — same reference, different behavior
        Patient[] patients = {p1, p2};

        for (Patient p : patients) {
            p.displayInfo();
        }

        // Billing
        double inpatientBill = p1.getDaysAdmitted() * p1.getRoomChargePerDay();
        Bill bill1 = new Bill(p1, inpatientBill);
        bill1.printBill();

        Bill bill2 = new Bill(p2, p2.getConsultationFee());
        bill2.printBill();
    }
}
