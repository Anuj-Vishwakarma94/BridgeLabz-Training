//Created class Named HeightConversion
import java.util.Scanner;
public class HeightConversion{
    public static void main(String[]args){
		
	//take height as the input from user and then convert it to inches then calculate the height in feet and inches
	Scanner input=new Scanner(System.in);
    double height=input.nextDouble();
	double inch=height/2.54;
	int heightininch=(int)inch;
    int feet=heightininch/12;
	int inches=heightininch%12;
	
    //print height in cm and in feet and inches as well	
	System.out.println("Your Height in cm is "+height+" while in feet is "+feet+" and inches is "+inches);
    }
}