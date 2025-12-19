//Created class Named SmallestNumber
import java.util.Scanner;
public class SmallestNumber{
   public static void main(String[]args){
   
   //take number1, number2, number3 as the input from the user and check whether the number1 is smallest or not and created an string to store the result
   Scanner input=new Scanner(System.in);
   int number1=input.nextInt();
   int number2=input.nextInt();
   int number3=input.nextInt();
   String ans;
   if(number1<number2 && number1<number3){
		ans="Yes";
        }
   else{
		ans="No";
		}
		
	//print that the number1 is smaller than number2 and number3
	System.out.println("Is the first number the smallest? "+ans);	
   }
}