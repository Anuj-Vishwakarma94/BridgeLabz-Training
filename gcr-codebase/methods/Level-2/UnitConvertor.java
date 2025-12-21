//Created class Named UnitConvertor
import java.util.Scanner;
public class UnitConvertor{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take km, miles, meter and feet as input
    double km=input.nextDouble();
    double miles=input.nextDouble();
    double meter=input.nextDouble();
    double feet=input.nextDouble();

    //print the conversion of units
    System.out.println("The respected conversion of unit are : " );
    System.out.println( km + " km in miles is " + convertKmToMiles(km)); 
    System.out.println( miles + " miles in km is " + convertMilesToKm(miles));
    System.out.println(meter + " meter in feet is " + convertMeterToFeet(meter));
    System.out.println(feet + " feet in meter is " + convertFeetToMeters(feet));
   }

   //method to convert kilometers to miles
   public static double convertKmToMiles(double km){
       double km2miles=0.621371;
       return km*km2miles;
   }

   //method to convert miles to kilometers
   public static double convertMilesToKm(double miles){
       double miles2km=1.60934;
       return miles*miles2km;
   }

   //method to convert meter to feet
   public static double convertMeterToFeet(double meter){
       double meters2feet=3.28084;
       return meter*meters2feet;
   }

   //method to convert feet to meters
   public static double convertFeetToMeters(double feet){
       double feet2meters=0.3048;
       return feet*feet2meters;
   }
}
