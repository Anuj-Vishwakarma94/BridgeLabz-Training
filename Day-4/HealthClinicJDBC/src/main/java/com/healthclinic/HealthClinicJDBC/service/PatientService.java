package com.healthclinic.HealthClinicJDBC.service;

import java.util.List;

import com.healthclinic.HealthClinicJDBC.dao.PatientDAO;
import com.healthclinic.HealthClinicJDBC.model.Patient;

public class PatientService {

    private PatientDAO patientDAO = new PatientDAO();

    public boolean addPatient(Patient patient) {

        if (patient.getName() == null || patient.getName().isBlank()) {
            System.out.println("Patient name cannot be empty");
            return false;
        }

        return patientDAO.addPatient(patient);
    }

    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    public Patient getPatientById(int id) {
        return patientDAO.getPatientById(id);
    }

    public boolean updatePatient(Patient patient) {
        return patientDAO.updatePatient(patient);
    }

    public boolean deletePatient(int id) {
        return patientDAO.deletePatient(id);
    }
}