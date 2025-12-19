//Created class Named BMICalculation2D
import java.util.Scanner;
public class BMICalculation2D{
   public static void main(String[]args){

    //take input for number of persons
    Scanner input=new Scanner(System.in);
    int persons=input.nextInt();

    double personData[][]=new double[persons][3];
    String weightStatus[]=new String[persons];

    //take input for weight and height of persons
    for(int i=0;i<persons;i++){
        double weight=input.nextDouble();
        double height=input.nextDouble();

        if(weight<=0 || height<=0){
            System.out.println("Please enter positive values");
            i--;
        }
        else{
            personData[i][0]=weight;
            personData[i][1]=height;
        }
    }

    //calculate BMI and weight status
    for(int i=0;i<persons;i++){
        double heightMeter=personData[i][1]/100;
        personData[i][2]=personData[i][0]/(heightMeter*heightMeter);

        if(personData[i][2]<=18.4){
            weightStatus[i]="Underweight";
        }
        else if(personData[i][2]>=18.5 && personData[i][2]<=24.9){
            weightStatus[i]="Normal";
        }
        else if(personData[i][2]>=25 && personData[i][2]<39.9){
            weightStatus[i]="Overweight";
        }
        else{
            weightStatus[i]="Obese";
        }
    }

    //Print height, weight, BMI and status of each person
    for(int i=0;i<persons;i++){
        System.out.println("Height(cm): " + personData[i][1]);
        System.out.println("Weight(kg): " + personData[i][0]);
        System.out.println("BMI: " + personData[i][2]);
        System.out.println("Status: " + weightStatus[i]);
    }
   }
}
