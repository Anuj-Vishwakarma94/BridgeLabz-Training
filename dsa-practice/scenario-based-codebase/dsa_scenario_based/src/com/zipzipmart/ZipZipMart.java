package com.zipzipmart;
import java.util.Scanner;

public class ZipZipMart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println(" ZipZipMart Daily Sales Report ");
        System.out.println("---------------------------------");

        System.out.print("\nEnter number of transactions: ");
        int n = sc.nextInt();
        sc.nextLine();

        Transaction[] transactions = new Transaction[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nTransaction date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            transactions[i] = new Transaction(date, amount);
        }

        System.out.println("\nBefore Sorting:");
        SalesReport.display(transactions);

        SalesReport.mergeSort(transactions, 0, n - 1);

        System.out.println("\nAfter Sorting (By Date → Amount):");
        SalesReport.display(transactions);

        sc.close();
    }
}
