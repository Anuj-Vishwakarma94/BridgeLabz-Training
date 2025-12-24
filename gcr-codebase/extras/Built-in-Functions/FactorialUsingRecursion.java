// Created class named FactorialUsingRecursion
import java.util.Scanner;
public class FactorialUsingRecursion {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int number=getInput(input);
        int result = factorial(number);
        displayResult(result);
    }
	//method to get input
    public static int getInput(Scanner input){
        return input.nextInt();
    }
	//method for factorial
    public static int factorial(int number) {
        if(number==0){
            return 1;
        }
        return number*factorial(number-1);
    }
	//method to diplay the result
    public static void displayResult(int result) {
        System.out.println("Factorial is: " + result);
    }
}
