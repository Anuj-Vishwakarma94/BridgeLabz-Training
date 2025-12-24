// Created class named FibonacciSequenceGenerator
import java.util.Scanner;

public class FibonacciSequenceGenerator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int terms = input.nextInt();
        printFibonacci(terms);
    }
    //method to print fibonacci series
    public static void printFibonacci(int terms) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
