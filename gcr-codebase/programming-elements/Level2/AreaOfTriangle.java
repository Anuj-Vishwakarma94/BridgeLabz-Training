//Created class Named AreaOfTriangle
import java.util.Scanner;
public class  AreaOfTriangle{
    public static void main(String args[]){

	//take base height as input from user then calculate the area then convert it in inches and centimetre
	Scanner input=new Scanner(System.in);
	double base=input.nextDouble();
    double height=input.nextDouble();
	double area=0.5*base*height; 
	double areaInches=area/(2.54*2.54);
	double areaCentimeters=area;
	 
	//print the area of triangle in incges and square centimetre
	System.out.println("Area of triangle in Inches is " + areaInches +" and in square centimetre is " +area);
	}
}
