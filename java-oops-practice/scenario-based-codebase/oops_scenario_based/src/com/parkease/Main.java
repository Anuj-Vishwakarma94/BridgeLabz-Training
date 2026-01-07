package com.parkease;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ParkingSystem ps = new ParkingSystem();

        ps.addSlot(new ParkingSlot("S1","Zone-A","Car"));
        ps.addSlot(new ParkingSlot("S2","Zone-B","Bike"));
        ps.addSlot(new ParkingSlot("S3","Zone-C","Truck"));

        System.out.println("Enter Vehicle Type (Car/Bike/Truck): ");
        String type = sc.nextLine();

        System.out.println("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.println("Enter Parking Duration in Hours: ");
        int hours = sc.nextInt();

        Vehicle v = null;

        if(type.equalsIgnoreCase("Car")){
            v = new Car(number);
        }
        else if(type.equalsIgnoreCase("Bike")){
            v = new Bike(number);
        }
        else if(type.equalsIgnoreCase("Truck")){
            v = new Truck(number);
        }
        else{
            System.out.println("Invalid Vehicle Type");
            return;
        }

        ParkingSlot slot = ps.assignSlot(v);

        if(slot != null){
            System.out.println("Slot Assigned: " + slot.getSlotId());
            System.out.println("Parking Charges: " + v.calculateCharges(hours));
            System.out.println(slot.getBookingLog());
        } else {
            System.out.println("No Slot Available for this vehicle type.");
        }

        sc.close();
    }
}
