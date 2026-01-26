package com.encapsulation.hospitalpatientmanagement;

import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {
	   public static void main(String[] args) {

	        List<Patient> patients = new ArrayList<>();

	        Patient p1 = new InPatient(101, "Akshat", 28, 5, 3000);
	        Patient p2 = new OutPatient(102, "Rohit", 35, 800);

	        patients.add(p1);
	        patients.add(p2);

	        for (Patient patient : patients) {

	            patient.getPatientDetails();

	            double bill = patient.calculateBill();
	            System.out.println("Total Bill: " + bill);

	            if (patient instanceof MedicalRecord) {
	                MedicalRecord record = (MedicalRecord) patient;
	                record.addRecord("Initial Diagnosis Completed");
	                System.out.println("Medical Records: " + record.viewRecords());
	            }

	            System.out.println("----------------------------");
	        }
	    }
}
