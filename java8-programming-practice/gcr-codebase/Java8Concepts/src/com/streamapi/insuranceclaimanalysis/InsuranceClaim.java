package com.streamapi.insuranceclaimanalysis;

public class InsuranceClaim {
	private int id;
    private String claimType; 
    private double amount;
    
    public InsuranceClaim(int id, String claimType, double amount) {
        this.id = id;
        this.claimType = claimType;
        this.amount = amount;
    }
    
    public String getClaimType() { return claimType; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
        return "Claim #" + id + " [" + claimType + ": $" + amount + "]";
    }
}
