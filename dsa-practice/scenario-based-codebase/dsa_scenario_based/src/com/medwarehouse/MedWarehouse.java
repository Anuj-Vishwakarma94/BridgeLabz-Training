package com.medwarehouse;
import java.util.Scanner;

public class MedWarehouse {

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
            if (L[i].expiryDays <= R[j].expiryDays)
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    static void display(Medicine[] arr) {
        for (Medicine m : arr)
            System.out.println(m.name + " → Expires in " + m.expiryDays + " days");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of medicines: ");
        int n = sc.nextInt();
        sc.nextLine();

        Medicine[] medicines = new Medicine[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Medicine name: ");
            String name = sc.nextLine();
            System.out.print("Days until expiry: ");
            int days = sc.nextInt();
            sc.nextLine();
            medicines[i] = new Medicine(name, days);
        }

        mergeSort(medicines, 0, n - 1);

        System.out.println("\nSorted Medicines by Expiry:");
        display(medicines);

        System.out.print("\nEnter alert threshold (days): ");
        int alertDays = sc.nextInt();

        System.out.println("\n⚠ Medicines Near Expiry:");
        for (Medicine m : medicines) {
            if (m.expiryDays <= alertDays)
                System.out.println(m.name + " → Expires in " + m.expiryDays + " days");
        }

        sc.close();
    }
}
