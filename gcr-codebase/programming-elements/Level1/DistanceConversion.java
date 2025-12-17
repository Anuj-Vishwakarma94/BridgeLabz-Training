//Created class Named DistanceConversion
import java.util.Scanner;
public class DistanceConversion{
    public static void main(String[]args){
	
	//take distance in km as the input and calculate the distance in miles
	Scanner input=new Scanner(System.in);
	double km=input.nextDouble();
	double miles=km/1.6;
	
	//print distance in miles as well as km
	System.out.println("The total miles is "+miles+" mile for the given "+km+" km");
    }
}