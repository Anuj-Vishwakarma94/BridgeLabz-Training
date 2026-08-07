package com.healthclinic.HealthClinicJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private int doctorId;
    private String doctorName;
    private String specialization;
    private String phone;
    private int departmentId;

    public Doctor(String doctorName, String specialization,
                  String phone, int departmentId) {
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.phone = phone;
        this.departmentId = departmentId;
    }
}