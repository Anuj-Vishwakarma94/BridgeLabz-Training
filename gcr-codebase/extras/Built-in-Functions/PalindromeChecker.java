// Created class named PalindromeChecker
import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = getInput(input);
        if (isPalindrome(text)) {
            displayResult(true);
        }
        else {
            displayResult(false);
        }
    }
    //method to get input
    public static String getInput(Scanner input) {
        return input.nextLine();
    }
    // method to check if it is palindrome
    public static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //method to displayResult
    public static void displayResult(boolean result) {
        if (result) {
            System.out.println("The given string is a Palindrome");
        }
        else {
            System.out.println("The given string is NOT a Palindrome");
        }
    }
}
