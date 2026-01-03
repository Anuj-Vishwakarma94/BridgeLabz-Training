package com.hospitalpatientmanagementsystem;
public class InPatient extends Patient {

    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(String id, String name, int age, String history,
                     int days, double charge, boolean emergency) {

        super(id, name, age, history, emergency);
        this.daysAdmitted = days;
        this.roomChargePerDay = charge;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    public double getRoomChargePerDay() {
        return roomChargePerDay;
    }

    @Override
    public void displayInfo() {
        System.out.println("InPatient: " + getSummary() +
                ", Days: " + daysAdmitted +
                ", Room Charge/Day: ₹" + roomChargePerDay);
    }
}
