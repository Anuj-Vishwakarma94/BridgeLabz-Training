package com.healthclinic.HealthClinicJDBC.service;

import java.util.List;

import com.healthclinic.HealthClinicJDBC.dao.DoctorDAO;
import com.healthclinic.HealthClinicJDBC.model.Doctor;

public class DoctorService {

    private DoctorDAO doctorDAO = new DoctorDAO();

    public boolean addDoctor(Doctor doctor) {
        return doctorDAO.addDoctor(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    public Doctor getDoctorById(int id) {
        return doctorDAO.getDoctorById(id);
    }

    public boolean updateDoctor(Doctor doctor) {
        return doctorDAO.updateDoctor(doctor);
    }

    public boolean deleteDoctor(int id) {
        return doctorDAO.deleteDoctor(id);
    }
}