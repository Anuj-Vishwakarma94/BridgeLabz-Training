package com.encapsulation.vehiclerentalsystem;

public class Bike extends Vehicle implements Insurable{
	private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) - 100; // discount for bikes
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (Policy Hidden)";
    }

    public void updatePolicyNumber(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }
}
