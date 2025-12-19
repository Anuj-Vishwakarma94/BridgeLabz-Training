//Created class Named LargestNumber
import java.util.Scanner;
public class LargestNumber{
   public static void main(String[]args){
   
   //take number1, number2, number3 as the input from the user and check which one is largest
   Scanner input=new Scanner(System.in);
   int number1=input.nextInt();
   int number2=input.nextInt();
   int number3=input.nextInt();
   String num1="No";
   String num2="No";
   String num3="No";
   if(number1>number2 && number1>number3){
		num1="Yes";
		num2="No";
		num3="No";
        }
   else if(number2>number1 && number2>number3){
        num1="No";
		num2="Yes";
		num3="No";
		}
	else if((number3>number1 && number3>number2)){	
		num1="No";
		num2="No";
		num3="Yes";
		}
	//print that the number1,number2 and number3 among them they are the largest number or not
	System.out.println("Is the first number the largest? "+num1);
	System.out.println("Is the second number the largest? "+num2);
	System.out.println("Is the third number the largest? "+num3);
   }
}