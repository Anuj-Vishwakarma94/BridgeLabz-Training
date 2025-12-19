//Created class Named CheckNumber
import java.util.Scanner;
public class CheckNumber{
   public static void main(String[]args){
   
   //take number as the input from the user and check whether it is positive, negative or zero
   Scanner input=new Scanner(System.in);
   int number=input.nextInt();
   String ans;
   if(number>0){
		ans="positive";
	    }
	else if(number<0){
	    ans="negative";
	    }
	else{
        ans="zero";
		}
	//print the sum of n natural number and check whether it is natural number or not
	    System.out.println(ans);
	}
}