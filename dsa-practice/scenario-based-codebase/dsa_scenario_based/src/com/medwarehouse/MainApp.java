package com.medwarehouse;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of medicines: ");
        int n = sc.nextInt();
        sc.nextLine();

        Medicine[] medicines = new Medicine[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Medicine name: ");
            String name = sc.nextLine();

            System.out.print("Expiry date (YYYY-MM-DD): ");
            LocalDate expiry = LocalDate.parse(sc.nextLine());

            medicines[i] = new Medicine(name, expiry);
        }

        MedWarehouse.mergeSort(medicines, 0, n - 1);

        System.out.println("\nMedicines Sorted by Expiry Date:");
        MedWarehouse.display(medicines);

        MedWarehouse.alertNearExpiry(medicines);
    }
}
