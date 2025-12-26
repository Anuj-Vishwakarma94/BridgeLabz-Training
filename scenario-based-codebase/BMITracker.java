//created class named BMITracker
import java.util.Scanner;
public class BMITracker{
    public static void main(String[] args) {
		
		//take height and weight as input
        Scanner input=new Scanner(System.in);
        System.out.println("Enter height in meters:");
        double height=input.nextDouble();
        System.out.println("Enter weight in kg:");
        double weight=input.nextDouble();
        double bmi=weight/(height*height);
		
		//display the bmi status
        System.out.println("BMI: "+bmi);
        if(bmi<18.5){
            System.out.println("Underweight");
        }
		else if(bmi<25){
            System.out.println("Normal");
        }
		else{
            System.out.println("Overweight");
        }
    }
}