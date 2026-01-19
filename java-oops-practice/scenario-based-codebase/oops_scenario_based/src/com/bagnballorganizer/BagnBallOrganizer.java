package com.bagnballorganizer;
import java.util.ArrayList;
import java.util.Scanner;

public class BagnBallOrganizer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Bag> bags = new ArrayList<>();

        System.out.println(" Bag-n-Ball Organizer \n");
        System.out.println(" TinyTown Play School ");
        System.out.println("---------------------------");

        while (true) {
            System.out.println("\n1. Add Bag");
            System.out.println("2. Add Ball to Bag");
            System.out.println("3. Remove Ball from Bag");
            System.out.println("4. Display Balls in a Bag");
            System.out.println("5. Display All Bags");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Bag ID: ");
                    String bagId = sc.nextLine();

                    System.out.print("Bag color: ");
                    String bagColor = sc.nextLine();

                    System.out.print("Bag capacity: ");
                    int capacity = sc.nextInt();
                    sc.nextLine();

                    bags.add(new Bag(bagId, bagColor, capacity));
                    System.out.println("Bag added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Bag ID: ");
                    String bId = sc.nextLine();

                    Bag bag = findBag(bags, bId);
                    if (bag == null) {
                        System.out.println("Bag not found.");
                        break;
                    }

                    System.out.print("Ball ID: ");
                    String ballId = sc.nextLine();

                    System.out.print("Ball color: ");
                    String ballColor = sc.nextLine();

                    System.out.print("Ball size (small/medium/large): ");
                    String size = sc.nextLine();

                    bag.addBall(new Ball(ballId, ballColor, size));
                    break;

                case 3:
                    System.out.print("Enter Bag ID: ");
                    String rbId = sc.nextLine();

                    Bag bagToRemove = findBag(bags, rbId);
                    if (bagToRemove == null) {
                        System.out.println("Bag not found.");
                        break;
                    }

                    System.out.print("Enter Ball ID: ");
                    String removeId = sc.nextLine();
                    bagToRemove.removeBall(removeId);
                    break;

                case 4:
                    System.out.print("Enter Bag ID: ");
                    String dbId = sc.nextLine();

                    Bag bagToDisplay = findBag(bags, dbId);
                    if (bagToDisplay == null) {
                        System.out.println("Bag not found.");
                        break;
                    }

                    bagToDisplay.displayBalls();
                    break;

                case 5:
                    for (Bag bg : bags) {
                        System.out.println(
                            "Bag ID: " + bg.getId() +
                            ", Ball Count: " + bg.getBallCount()
                        );
                    }
                    break;

                case 6:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static Bag findBag(ArrayList<Bag> bags, String id) {
        for (Bag b : bags) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
}
