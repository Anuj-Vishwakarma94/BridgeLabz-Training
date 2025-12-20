//Created class Named WindChill
import java.util.Scanner;
public class WindChill{
   public static void main(String[]args){

    //take input for temperature and windSpeed
    Scanner input=new Scanner(System.in);
    double temperature=input.nextDouble();
    double windSpeed=input.nextDouble();
    double windChill=calculateWindChill(temperature,windSpeed);

    //print the windChill temperature
    System.out.println(windChill);
   }

   //method to calculate windChill temperature
   public static double calculateWindChill(double temperature, double windSpeed){
       return 35.74 + 0.6215 *temperature + (0.4275*temperature - 35.75) * Math.pow(windSpeed,0.16);
   }
}
