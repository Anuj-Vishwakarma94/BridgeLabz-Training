//Created class Named EligibleToVote
import java.util.Scanner;
public class EligibleToVote{
   public static void main(String[]args){
   
   //take age as the input from the user and check whether they are eligible to vote or not
   Scanner input=new Scanner(System.in);
   int age=input.nextInt();
   boolean check=false;
   if(age>=18){
		check=true;
	    }
	else{
	    check=false;
	    }
		
	//print the person age and whether they can vote or not
	if(check==true){
	    System.out.println("The person's age is "+age+" and can vote.");
		}
		else{
		System.out.println("The person's age is "+age+" and cannot vote.");
		}
   }
}