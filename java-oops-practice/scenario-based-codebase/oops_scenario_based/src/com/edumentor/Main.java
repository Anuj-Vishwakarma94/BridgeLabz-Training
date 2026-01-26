package com.edumentor;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Learner Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter Course Type (short/full-time): ");
        String courseType = sc.nextLine();

        // create learner from user input
        Learner l1 = new Learner(name, email, userId, courseType);
        l1.displayDetails();

        System.out.print("Enter Quiz Difficulty (easy/hard): ");
        String difficulty = sc.nextLine();

        Quiz quiz = new Quiz(difficulty);

        List<String> userAns = new ArrayList<>();

        System.out.println("\nQuiz Time!");
        for(String q : quiz.getQuestions()) {
            System.out.println(q);
            userAns.add(sc.nextLine());
        }

        quiz.attemptQuiz(userAns);

        System.out.println("\nScore = " + quiz.getScore());
        System.out.println("Percentage = " + quiz.getPercentage() + "%");

        l1.generateCertificate();

        sc.close();
    }
}
