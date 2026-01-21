package com.medwarehouse;
import java.time.LocalDate;

class MedWarehouse {

    static void mergeSort(Medicine[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(Medicine[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Medicine[] L = new Medicine[n1];
        Medicine[] R = new Medicine[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].expiryDate.isBefore(R[j].expiryDate) ||
                L[i].expiryDate.isEqual(R[j].expiryDate)) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    static void display(Medicine[] arr) {
        for (Medicine m : arr) {
            System.out.println(m.name + " → Expiry: " + m.expiryDate);
        }
    }

    static void alertNearExpiry(Medicine[] arr) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        System.out.println("\nNear Expiry Medicines (within 30 days):");
        for (Medicine m : arr) {
            if (!m.expiryDate.isAfter(limit)) {
                System.out.println(m.name + " → Expires on " + m.expiryDate);
            }
        }
    }
}
