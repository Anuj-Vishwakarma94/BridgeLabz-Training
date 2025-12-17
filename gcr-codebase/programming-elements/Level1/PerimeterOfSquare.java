//Created class Named PerimeterOfSquare
import java.util.Scanner;
public class  PerimeterOfSquare{
    public static void main(String args[]){
	
	//take perimeter as the input from user and then calculate its side
	Scanner input=new Scanner(System.in);
	int perimeter=input.nextInt();
    int side=(perimeter/4);
	
	//print the length of the side with their corresponding perimeter
	System.out.println("The length of the side is " + side +" whose perimeter is " + perimeter); 
	}
}