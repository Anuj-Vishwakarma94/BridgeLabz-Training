package com.healthclinic.HealthClinicJDBC.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    private int visitId;
    private int appointmentId;
    private Timestamp visitDate;
    private String diagnosis;

    public Visit(int appointmentId,
                 Timestamp visitDate,
                 String diagnosis) {

        this.appointmentId = appointmentId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;

    }

}