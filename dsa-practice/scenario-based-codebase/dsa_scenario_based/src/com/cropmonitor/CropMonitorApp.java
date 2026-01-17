package com.cropmonitor;

import java.util.Scanner;

public class CropMonitorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----CropMonitor-----");
        System.out.print("Number of readings: ");
        int n = sc.nextInt();
        sc.nextLine();

        CropMonitor farm = new CropMonitor(n);

        System.out.println("Enter time (HH:MM) and temperature");
        for (int i = 0; i < n; i++) {
            System.out.print("Time " + (i + 1) + ": ");
            String t = sc.nextLine();

            System.out.print("Temp: ");
            double temp = sc.nextDouble();
            sc.nextLine();

            farm.add(new Reading(t, temp));
        }

        farm.quickSort();
        farm.print();

        System.out.println("Done");
        sc.close();
    }
}