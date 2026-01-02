package com.encapsulation.hospitalpatientmanagement;

import java.util.ArrayList;
import java.util.List;

public class InPatient extends Patient implements MedicalRecord{
	 private int daysAdmitted;
	    private double roomChargePerDay;
	    private List<String> medicalHistory = new ArrayList<>();

	    public InPatient(int patientId, String name, int age,
	                     int daysAdmitted, double roomChargePerDay) {
	        super(patientId, name, age);
	        this.daysAdmitted = daysAdmitted;
	        this.roomChargePerDay = roomChargePerDay;
	    }

	    @Override
	    public double calculateBill() {
	        return daysAdmitted * roomChargePerDay + 5000; // treatment charges
	    }

	    @Override
	    public void addRecord(String record) {
	        medicalHistory.add(record);
	    }

	    @Override
	    public List<String> viewRecords() {
	        return medicalHistory;
	    }
}
