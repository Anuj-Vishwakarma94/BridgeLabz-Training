package com.constructors.level1;

import java.util.Scanner;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    int costPerDay;

    // constructor
    CarRental(String name, String model, int days) {
        customerName = name;
        carModel = model;
        rentalDays = days;

    
        switch (model.toLowerCase()) {
            case "suv":
                costPerDay = 2000;
                break;

            case "lmg":    
                costPerDay = 1500;
                break;

            case "sedan":
                costPerDay = 1200;
                break;

            default:
                costPerDay = 1000;   
        }
    }

    // method to calculate total cost
    int calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();

        System.out.print("Enter Car Type (SUV / LMG / Sedan): ");
        String model = input.nextLine();

        System.out.print("Enter Rental Days: ");
        int days = input.nextInt();

        CarRental c1 = new CarRental(name, model, days);
        System.out.println("Total Cost: " + c1.calculateTotalCost());
        input.close();
    }
}
