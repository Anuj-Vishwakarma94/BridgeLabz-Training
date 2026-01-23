package com.hospitalqueuemanagement;

public class PatientNode {

    int checkInTime;   
    String patientName;

    int height;

    PatientNode left;
    PatientNode right;

    PatientNode(int checkInTime, String patientName) {
        this.checkInTime = checkInTime;
        this.patientName = patientName;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

