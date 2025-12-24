// Created class named NumberGuessingGame
import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean guessed = false;
        while (!guessed) {
            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);
            String feedback = getFeedback(input);
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed the correct number!");
                guessed = true;
            }
            else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            }
            else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
        }
    }
    // method to generateGuess
    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
    //method to getFeedback
    public static String getFeedback(Scanner input) {
        System.out.println("Enter feedback (high / low / correct): ");
        return input.next();
    }
}
