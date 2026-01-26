package com.petpal;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to PetPal!");
        System.out.print("Enter your pet name: ");
        String name = sc.nextLine();

        System.out.println("Choose Pet Type: 1.Dog  2.Cat  3.Bird");
        int ch = sc.nextInt();

        System.out.print("Enter pet age: ");
        int age = sc.nextInt();

        Pet pet;

        switch (ch) {
            case 1: pet = new Dog(name, age); break;
            case 2: pet = new Cat(name, age); break;
            case 3: pet = new Bird(name, age); break;
            default:
                System.out.println("Invalid choice! Dog adopted by default.");
                pet = new Dog(name, age);
        }

        pet.makeSound();
        pet.showStatus();

        int option;
        do {
            System.out.println("\n1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Sleep");
            System.out.println("4. Show Status");
            System.out.println("5. Exit");
            option = sc.nextInt();

            switch (option) {
                case 1: pet.feed(); break;
                case 2: pet.play(); break;
                case 3: pet.sleep(); break;
                case 4: pet.showStatus(); break;
                case 5: System.out.println("Goodbye! Take care of your pet!"); break;
                default: System.out.println("Invalid option.");
            }

        } while (option != 5);

        sc.close();
    }
}
