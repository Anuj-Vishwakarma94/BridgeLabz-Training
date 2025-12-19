//Created class Named NaturalNumber
import java.util.Scanner;
public class NaturalNumber{
   public static void main(String[]args){
   
   //take number as the input from the user and check if it is natural number or not and calulate the sum of first n natural numbers
   Scanner input=new Scanner(System.in);
   int number=input.nextInt();
   boolean check=false;
   int sum=number*(number+1)/2;
   if(number>=0){
		check=true;
	    }
	else{
	    check=false;
	    }
		
	//print the sum of n natural number and check whether it is natural number or not
	if(check==true){
	    System.out.println("The sum of "+number+" natural numbers is "+ sum);
		}
	else{
		System.out.println("The number "+number+" is not a natural number");
		}
   }
}