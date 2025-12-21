//Created class Named BMICalculation
import java.util.Scanner;
public class BMICalculation{
   public static void main(String[]args){

    //take input for weight and height of 10 persons
    Scanner input=new Scanner(System.in);
    double personData[][]=new double[10][3];
    for(int i=0;i<10;i++){
        personData[i][0]=input.nextDouble(); 
        personData[i][1]=input.nextDouble(); 
    }
    calculateBMI(personData);
    String status[]=findBMIStatus(personData);

    //display height, weight, BMI and status of each person
    for(int i=0;i<10;i++){
        System.out.println("Weight(kg): " + personData[i][0]);
        System.out.println("Height(cm): " + personData[i][1]);
        System.out.println("BMI: " + personData[i][2]);
        System.out.println("Status: " + status[i]);
    }
   }

   //method to calculate BMI and store in array
   public static void calculateBMI(double personData[][]){
       for(int i=0;i<personData.length;i++){
           double heightMeter=personData[i][1]/100;
           personData[i][2]=personData[i][0]/(heightMeter*heightMeter);
       }
   }

   //method to find BMI status
   public static String[] findBMIStatus(double personData[][]){
       String status[]=new String[personData.length];

       for(int i=0;i<personData.length;i++){
           if(personData[i][2]<=18.4){
               status[i]="Underweight";
           }
           else if(personData[i][2]>=18.5 && personData[i][2]<=24.9){
               status[i]="Normal";
           }
           else if(personData[i][2]>=25.0 && personData[i][2]<=39.9){
               status[i]="Overweight";
           }
           else{
               status[i]="Obese";
           }
       }

       return status;
   }
}
