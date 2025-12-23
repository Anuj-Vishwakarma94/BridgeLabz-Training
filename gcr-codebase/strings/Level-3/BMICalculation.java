//Created class Named BMICalculation
import java.util.Scanner;
public class BMICalculation{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    int persons=10;
    double heightWeight[][]=new double[persons][2];

    //take input for weight and height
    for(int i=0;i<persons;i++){
        heightWeight[i][0]=input.nextDouble(); 
        heightWeight[i][1]=input.nextDouble(); 
    }
    String bmiResult[][]=calculateBMIForPersons(heightWeight);

    //display BMI details
    displayBMIResult(bmiResult);
   }

   //method to calculate BMI and status for all persons
   public static String[][] calculateBMIForPersons(double heightWeight[][]){
       String result[][]=new String[heightWeight.length][4];

       for(int i=0;i<heightWeight.length;i++){
           double weight=heightWeight[i][0];
           double heightCm=heightWeight[i][1];
           double heightMeter=heightCm/100;
           double bmi=weight/(heightMeter*heightMeter);
           bmi=Math.round(bmi*100.0)/100.0;

           String status=findBMIStatus(bmi);

           result[i][0]=String.valueOf(heightCm);
           result[i][1]=String.valueOf(weight);
           result[i][2]=String.valueOf(bmi);
           result[i][3]=status;
       }

       return result;
   }

   //method to find BMI status
   public static String findBMIStatus(double bmi){

       if(bmi<=18.4){
           return "Underweight";
       }
       else if(bmi<=24.9){
           return "Normal";
       }
       else if(bmi<=39.9){
           return "Overweight";
       }
       else{
           return "Obese";
       }
   }

   //method to display BMI details in tabular format
   public static void displayBMIResult(String result[][]){

       System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");

       for(int i=0;i<result.length;i++){
           System.out.println(result[i][0] + "\t\t" +result[i][1] + "\t\t" + result[i][2] + "\t" + result[i][3]);
       }
   }
}
