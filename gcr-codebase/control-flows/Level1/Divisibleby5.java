//Created class Named Divisibleby5
import java.util.Scanner;
public class Divisibleby5{
   public static void main(String[]args){
   
   //take number as the input from the user and check whether it is divisible by 5 or not and created an string to store the result
   Scanner input=new Scanner(System.in);
   int number=input.nextInt();
   String ans;
   if(number%5==0){
		ans="Yes";
        }
   else{
		ans="No";
		}
		
	//print that the number is divisible by 5 or not
	System.out.println("Is the number "+number+" divisible by 5? "+ans);	
   }
}