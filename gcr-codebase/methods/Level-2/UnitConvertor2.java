//Created class Named UnitConvertor2
import java.util.Scanner;
public class UnitConvertor2{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take yards, feet, meters and inches as input
    double yards=input.nextDouble();
    double feet=input.nextDouble();
    double meters=input.nextDouble();
    double inches=input.nextDouble();

    //print the conversion of units
    System.out.println("The respected conversion of unit are : ");
    System.out.println(yards + " yards in feet is " + convertYardsToFeet(yards));
    System.out.println(feet + " feet in yards is " + convertFeetToYards(feet));
    System.out.println(meters + " meters in inches is " + convertMetersToInches(meters));
    System.out.println(inches + " inches in meters is " + convertInchesToMeters(inches));
    System.out.println(inches + " inches in centimeters is " + convertInchesToCentimeters(inches));
   }

   //method to convert yards to feet
   public static double convertYardsToFeet(double yards){
       double yards2feet=3;
       return yards*yards2feet;
   }

   //method to convert feet to yards
   public static double convertFeetToYards(double feet){
       double feet2yards=0.333333;
       return feet*feet2yards;
   }

   //method to convert meters to inches
   public static double convertMetersToInches(double meters){
       double meters2inches=39.3701;
       return meters*meters2inches;
   }

   //method to convert inches to meters
   public static double convertInchesToMeters(double inches){
       double inches2meters=0.0254;
       return inches*inches2meters;
   }

   //method to convert inches to centimeters
   public static double convertInchesToCentimeters(double inches){
       double inches2cm=2.54;
       return inches*inches2cm;
   }
}
