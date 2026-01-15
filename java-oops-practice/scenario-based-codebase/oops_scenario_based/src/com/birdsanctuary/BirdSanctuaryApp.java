package com.birdsanctuary;

import java.util.*;

public class BirdSanctuaryApp {

    static ArrayList<Bird> birds = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- EcoWing Bird Sanctuary ---");
            System.out.println("1. Add Bird");
            System.out.println("2. Display All Birds");
            System.out.println("3. Display Flying Birds");
            System.out.println("4. Display Swimming Birds");
            System.out.println("5. Remove Bird by ID");
            System.out.println("6. Sanctuary Report");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBird(); break;
                case 2: displayAll(); break;
                case 3: displayFlying(); break;
                case 4: displaySwimming(); break;
                case 5: removeBird(); break;
                case 6: report(); break;
                case 7: System.exit(0);
            }
        }
    }

    static void addBird() {

        System.out.println("Enter Bird ID:");
        String id = sc.next();

        System.out.println("Enter Bird Name:");
        String name = sc.next();

        System.out.println("Select Bird Type:");
        System.out.println("1. Eagle");
        System.out.println("2. Duck");
        System.out.println("3. Penguin");
        System.out.println("4. Ostrich");

        int type = sc.nextInt();

        Bird bird = null;

        if (type == 1) bird = new Eagle(id, name);
        else if (type == 2) bird = new Duck(id, name);
        else if (type == 3) bird = new Penguin(id, name);
        else if (type == 4) bird = new Ostrich(id, name);

        if (bird != null) {
            birds.add(bird);
            System.out.println("Bird Added Successfully");
        }
    }

    static void displayAll() {

        for (Bird b : birds) {
            b.display();
            if (b instanceof Flyable)
                ((Flyable) b).fly();
            if (b instanceof Swimmable)
                ((Swimmable) b).swim();
            if (!(b instanceof Flyable) && !(b instanceof Swimmable))
                System.out.println("No Special Ability");
        }
    }

    static void displayFlying() {
        for (Bird b : birds) {
            if (b instanceof Flyable) {
                b.display();
                ((Flyable) b).fly();
            }
        }
    }

    static void displaySwimming() {
        for (Bird b : birds) {
            if (b instanceof Swimmable) {
                b.display();
                ((Swimmable) b).swim();
            }
        }
    }

    static void removeBird() {

        System.out.println("Enter Bird ID to Remove:");
        String id = sc.next();

        Iterator<Bird> it = birds.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                System.out.println("Bird Removed");
                return;
            }
        }
        System.out.println("Bird Not Found");
    }

    static void report() {

        int fly = 0, swim = 0, both = 0, neither = 0;

        for (Bird b : birds) {
            boolean f = b instanceof Flyable;
            boolean s = b instanceof Swimmable;

            if (f && s) both++;
            else if (f) fly++;
            else if (s) swim++;
            else neither++;
        }

        System.out.println("Flying Birds: " + fly);
        System.out.println("Swimming Birds: " + swim);
        System.out.println("Both: " + both);
        System.out.println("Neither: " + neither);
    }
}
