package com.encapsulation.hospitalpatientmanagement;

import java.util.ArrayList;
import java.util.List;

public class OutPatient extends Patient implements MedicalRecord{
	    private double consultationFee;
	    private List<String> medicalHistory = new ArrayList<>();

	    public OutPatient(int patientId, String name, int age, double consultationFee) {
	        super(patientId, name, age);
	        this.consultationFee = consultationFee;
	    }

	    @Override
	    public double calculateBill() {
	        return consultationFee;
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
