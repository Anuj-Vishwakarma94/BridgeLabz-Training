// Created class named BasicCalculator
import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        String operation=input.next();
		
		//display the result
        if(operation.equals("+")) {
            System.out.println("Result: " + add(a, b));
        }
        else if(operation.equals("-")) {
            System.out.println("Result: " + subtract(a, b));
        }
        else if(operation.equals("*")) {
            System.out.println("Result: " + multiply(a, b));
        }
        else if(operation.equals("/")) {
            System.out.println("Result: " + divide(a, b));
        }
    }
    
	//method to perform calculation operation
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static int divide(int a, int b) {
        return a / b;
    }
}
