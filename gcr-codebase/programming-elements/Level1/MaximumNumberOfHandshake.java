//Created class Named MaximumNumberOfHandshake
import java.util.Scanner;
public class MaximumNumberOfHandshake{
    public static void main(String args[]){

    //take numberOfStudents as the input from user and then calculate total hand shakes
	Scanner input=new Scanner(System.in);
	int numberOfStudents=input.nextInt();
	int totalHandshakes=((numberOfStudents*(numberOfStudents - 1))/2);
	
	//print number of possible handshakes 
	System.out.println("Number of Possible Handshakes: " + totalHandshakes ); 
	}
}