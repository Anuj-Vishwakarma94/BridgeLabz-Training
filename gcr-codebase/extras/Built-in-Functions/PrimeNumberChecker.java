// Created class named PrimeNumberChecker
import java.util.Scanner;
public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (isPrime(number)) {
            System.out.println("The number is a Prime Number");
        }
        else {
            System.out.println("The number is NOT a Prime Number");
        }
    }
    //method to check if it is Prime or not
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
