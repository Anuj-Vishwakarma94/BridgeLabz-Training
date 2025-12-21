//Created class Named UnitConvertor3
import java.util.Scanner;
public class UnitConvertor3{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take fahrenheit, celsius, pounds, kilograms, gallons and liters as input
    double fahrenheit=input.nextDouble();
    double celsius=input.nextDouble();
    double pounds=input.nextDouble();
    double kilograms=input.nextDouble();
    double gallons=input.nextDouble();
    double liters=input.nextDouble();

    //print the conversion of units
    System.out.println("The respected conversion of unit are : ");
    System.out.println(fahrenheit + " fahrenheit in celsius is " + convertFarhenheitToCelsius(fahrenheit));
    System.out.println(celsius + " celsius in fahrenheit is " + convertCelsiusToFarhenheit(celsius));
    System.out.println(pounds + " pounds in kilograms is " + convertPoundsToKilograms(pounds));
    System.out.println(kilograms + " kilograms in pounds is " + convertKilogramsToPounds(kilograms));
    System.out.println(gallons + " gallons in liters is " + convertGallonsToLiters(gallons));
    System.out.println(liters + " liters in gallons is " + convertLitersToGallons(liters));
   }

   //method to convert fahrenheit to celsius
   public static double convertFarhenheitToCelsius(double farhenheit){
       double farhenheit2celsius=(farhenheit-32)*5/9;
       return farhenheit2celsius;
   }

   //method to convert celsius to fahrenheit
   public static double convertCelsiusToFarhenheit(double celsius){
       double celsius2farhenheit=(celsius*9/5)+32;
       return celsius2farhenheit;
   }

   //method to convert pounds to kilograms
   public static double convertPoundsToKilograms(double pounds){
       double pounds2kilograms=0.453592;
       return pounds*pounds2kilograms;
   }

   //method to convert kilograms to pounds
   public static double convertKilogramsToPounds(double kilograms){
       double kilograms2pounds=2.20462;
       return kilograms*kilograms2pounds;
   }

   //method to convert gallons to liters
   public static double convertGallonsToLiters(double gallons){
       double gallons2liters=3.78541;
       return gallons*gallons2liters;
   }

   //method to convert liters to gallons
   public static double convertLitersToGallons(double liters){
       double liters2gallons=0.264172;
       return liters*liters2gallons;
   }
}
