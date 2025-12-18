//Created class named IntOperations
import java.util.Scanner;
public class QuotientandRemainder{
    public static void main(String args[]){
	
	//take number1 and number2 as input from the user and calculate its Quotient and Remainder
	Scanner input=new Scanner(System.in);
	int number1=input.nextInt();
	int number2=input.nextInt();
	int quotient=number1/number2;
	int remainder=number1%number2;
	  
	//print the values of quotient and remainder 
	System.out.println("The Quotient is "+quotient+" and Remainder is "+remainder+" of two number "+number1+" and "+number2);
	}
}