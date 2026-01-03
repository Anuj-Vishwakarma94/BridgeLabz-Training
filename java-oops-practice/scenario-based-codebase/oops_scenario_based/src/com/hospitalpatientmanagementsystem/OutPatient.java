package com.hospitalpatientmanagementsystem;
public class OutPatient extends Patient {

    private double consultationFee;

    public OutPatient(String id, String name, int age, String history,
                      double fee, boolean emergency) {

        super(id, name, age, history, emergency);
        this.consultationFee = fee;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("OutPatient: " + getSummary() +
                ", Consultation Fee: ₹" + consultationFee);
    }
}
