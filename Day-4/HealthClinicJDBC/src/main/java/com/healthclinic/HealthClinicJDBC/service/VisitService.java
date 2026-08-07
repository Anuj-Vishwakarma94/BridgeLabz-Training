package com.healthclinic.HealthClinicJDBC.service;

import java.util.List;

import com.healthclinic.HealthClinicJDBC.dao.VisitDAO;
import com.healthclinic.HealthClinicJDBC.model.Visit;

public class VisitService {

    private VisitDAO visitDAO = new VisitDAO();

    public boolean addVisit(Visit visit) {

        if (visit.getDiagnosis() == null ||
            visit.getDiagnosis().isBlank()) {

            System.out.println("Diagnosis cannot be empty.");
            return false;
        }

        return visitDAO.addVisit(visit);
    }

    public List<Visit> getAllVisits() {
        return visitDAO.getAllVisits();
    }

    public Visit getVisitById(int visitId) {
        return visitDAO.getVisitById(visitId);
    }

    public boolean updateVisit(Visit visit) {
        return visitDAO.updateVisit(visit);
    }

    public boolean deleteVisit(int visitId) {
        return visitDAO.deleteVisit(visitId);
    }
    
    public void viewVisitDetails() {
        visitDAO.viewVisitDetails();
    }
    
    public List<Visit> getVisitsByAppointment(int appointmentId) {
        return visitDAO.getVisitsByAppointment(appointmentId);
    }

}