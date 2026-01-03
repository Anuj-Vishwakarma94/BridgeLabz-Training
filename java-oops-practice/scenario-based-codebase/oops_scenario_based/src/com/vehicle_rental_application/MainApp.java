package com.vehicle_rental_application;
public class MainApp {

    public static void main(String[] args) {

        Customer c1 = new Customer("C101", "Anuj Vishwakarma");
        c1.displayInfo();

        System.out.println();

        Vehicle v1 = new Bike("B001", "Yamaha Fz-s", 300, true);
        Vehicle v2 = new Car("C201", "Koenigsegg Jesko", 2000, true);
        Vehicle v3 = new Truck("T501", "Tata Motors", 3500, 8);

        Vehicle[] vehicles = {v1, v2, v3};

        for (Vehicle v : vehicles) {
            v.displayInfo();
        }

        System.out.println("\n--- RENT DETAILS ---");

        System.out.println("Bike Rent (6 days): ₹" + v1.calculateRent(6));
        System.out.println("Car Rent (8 days): ₹" + v2.calculateRent(8));
        System.out.println("Truck Rent (3 days): ₹" + v3.calculateRent(3));
    }
}
