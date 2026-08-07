package com.healthclinic.HealthClinicJDBC.service;

import java.util.List;

import com.healthclinic.HealthClinicJDBC.dao.AppointmentDAO;
import com.healthclinic.HealthClinicJDBC.model.Appointment;

public class AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public boolean addAppointment(Appointment appointment) {
        return appointmentDAO.addAppointment(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    public boolean updateStatus(int appointmentId, String status) {
        return appointmentDAO.updateStatus(appointmentId, status);
    }

    public boolean deleteAppointment(int id) {
        return appointmentDAO.deleteAppointment(id);
    }
}