package com.hospitalqueue;
public class HospitalQueue {

    // Bubble Sort by criticality (descending)
    public static void sortByCriticality(Patient[] patients, int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (patients[j].criticality < patients[j + 1].criticality) {
                    // swap adjacent patients
                    Patient temp = patients[j];
                    patients[j] = patients[j + 1];
                    patients[j + 1] = temp;
                }
            }
        }
    }

    public static void display(Patient[] patients, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(
                patients[i].name + " | Criticality: " + patients[i].criticality
            );
        }
    }
}
