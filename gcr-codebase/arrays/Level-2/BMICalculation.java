//Created class Named BMICalculation
import java.util.Scanner;
public class BMICalculation{
   public static void main(String[]args){

    //take input for number of persons
    Scanner input=new Scanner(System.in);
    int persons=input.nextInt();

    double weight[]=new double[persons];
    double height[]=new double[persons];
    double bmi[]=new double[persons];
    String status[]=new String[persons];

    //take input for weight and height of persons (height in cm)
    for(int i=0;i<persons;i++){
        weight[i]=input.nextDouble();
        height[i]=input.nextDouble();
    }

    //calculate BMI and weight status
    for(int i=0;i<persons;i++){
        double heightMeter=height[i]/100;
        bmi[i]=weight[i]/(heightMeter*heightMeter);

        if(bmi[i]<=18.4){
            status[i]="Underweight";
        }
        else if(bmi[i]>=18.5 && bmi[i]<=24.9){
            status[i]="Normal";
        }
        else if(bmi[i]>=25 && bmi[i]<39.9){
            status[i]="Overweight";
        }
        else{
            status[i]="Obese";
        }
    }

    //display height, weight, BMI and status of each person
    for(int i=0;i<persons;i++){
        System.out.println("Height : " + height[i]);
        System.out.println("Weight : " + weight[i]);
        System.out.println("BMI : " + bmi[i]);
        System.out.println("Status : " + status[i]);
    }
   }
}
