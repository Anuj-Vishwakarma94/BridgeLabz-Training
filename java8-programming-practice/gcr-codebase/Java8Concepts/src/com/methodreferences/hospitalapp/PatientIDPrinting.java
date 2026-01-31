package com.methodreferences.hospitalapp;

import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {

        List<Integer> patientIds = Arrays.asList(101, 102, 103, 104);

        // Method reference instead of lambda
        patientIds.forEach(System.out::println);
    }
}
