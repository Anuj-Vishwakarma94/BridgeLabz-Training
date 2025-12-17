//Created class Named Calculator
import java.util.Scanner;
public class Calculator{
    public static void main(String[]args){
	
	//take number1 and number2 as input from user then calculate their addition,subtraction,multiplication and division	
	Scanner input=new Scanner(System.in);
	double number1=input.nextDouble();
	double number2=input.nextDouble();
	double addition=number1+number2;
	double subtraction=number1-number2;
	double multiplication=number1*number2;
	double division=number1/number2;
	
	//Print the two numbers with their addition,subtraction,multiplication and division
	System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+addition+","+subtraction+","+multiplication+","+" and "+division);
    }
}