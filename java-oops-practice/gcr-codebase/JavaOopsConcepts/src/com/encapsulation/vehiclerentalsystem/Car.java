package com.encapsulation.vehiclerentalsystem;

public class Car extends Vehicle implements Insurable{
    // Sensitive data
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500; // Flat insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy Hidden)";
    }

    // Encapsulation: controlled access
    public void updatePolicyNumber(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }

}
