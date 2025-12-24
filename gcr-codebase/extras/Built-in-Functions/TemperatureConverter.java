//Create a class TemperatureConverter to convert Fahrenheit to Celcius or Celcius to Fahrenheit 
import java.util.*;
public class TemperatureConverter{ 
    //Method to convert Fahrenheit to Celsius 
    public static double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit-32)*5/9;
    }
    //Method to convert Celsius to Fahrenheit 
    public static double celsiusToFahrenheit(double celsius){
        return (celsius*9/5)+32;
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice=input.nextInt();
        if(choice==1){
            System.out.print("Enter temperature in Fahrenheit: ");
            double f=input.nextDouble();
            double c=fahrenheitToCelsius(f);
            System.out.println("Temperature in Celsius: "+c);
       }
        else if(choice==2){
            System.out.print("Enter temperature in Celsius: ");
            double c=input.nextDouble();
            double f=celsiusToFahrenheit(c);
            System.out.println("Temperature in Fahrenheit: "+f);
       }
        else{
            System.out.println("Invalid choice!");
        
    }
}
