package com.fittrack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter your Daily Calorie Burn Target: ");
        int target = sc.nextInt();

        UserProfile user = new UserProfile(name, age, weight, target);

        System.out.println("\nChoose Workout Type:");
        System.out.println("1. Cardio");
        System.out.println("2. Strength");
        int choice = sc.nextInt();

        System.out.print("Enter Workout Duration (minutes): ");
        int duration = sc.nextInt();

        Workout workout;

        if(choice == 1)
            workout = new CardioWorkout(duration);
        else
            workout = new StrengthWorkout(duration);

        workout.startWorkout();
        workout.calculateCalories();
        workout.stopWorkout();

        double burned = workout.getCaloriesBurned();

        System.out.println("\nCalories Burned Today: " + burned);

        double remaining = user.getDailyTarget() - burned;

        if(remaining > 0)
            System.out.println("You still need to burn: " + remaining + " calories.");
        else
            System.out.println("Goal Achieved! Extra calories burned: " + Math.abs(remaining));

        sc.close();
    }
}
