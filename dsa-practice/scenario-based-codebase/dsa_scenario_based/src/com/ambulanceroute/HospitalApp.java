package com.ambulanceroute;
import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AmbulanceRoute route = new AmbulanceRoute();

        System.out.print("Enter number of hospital units: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter unit name: ");
            String name = sc.next();

            System.out.print("Is unit available (true/false): ");
            boolean available = sc.nextBoolean();

            route.addUnit(name, available);
        }

        while (true) {
            System.out.println("\n1. Display Units");
            System.out.println("2. Find Available Unit");
            System.out.println("3. Remove Unit");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    route.displayUnits();
                    break;

                case 2:
                    System.out.print("Enter starting unit: ");
                    String start = sc.next();
                    route.findAvailableUnit(start);
                    break;

                case 3:
                    System.out.print("Enter unit to remove: ");
                    String remove = sc.next();
                    route.removeUnit(remove);
                    break;

                case 4:
                    System.exit(0);
            }
        }    
    }
}
