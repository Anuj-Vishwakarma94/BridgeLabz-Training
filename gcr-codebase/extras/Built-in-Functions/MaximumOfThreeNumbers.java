// Created class named MaximumOfThreeNumbers
import java.util.Scanner;
public class MaximumOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int max = findMaximum(a, b, c);
        System.out.println("Maximum value is: " + max);
    }
    //method to find maximum
    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
