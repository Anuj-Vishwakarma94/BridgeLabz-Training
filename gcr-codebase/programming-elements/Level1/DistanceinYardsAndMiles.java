//Created class named DistanceinYardsAndMiles
import java.util.Scanner;
public class  DistanceinYardsAndMiles{
    public static void main(String args[]){
	
	//take distance in feet as the input from the user and calculate the distance in miles and yards	
	Scanner input=new Scanner(System.in);	
	double distanceInFeet=input.nextDouble();
    double miles=(distanceInFeet/5280);
	double yards=(distanceInFeet/3);
	
	//print the distance in yards and miles
	System.out.println("The distance in Yards and Miles is " + yards + " & "  + miles);  
	}
}