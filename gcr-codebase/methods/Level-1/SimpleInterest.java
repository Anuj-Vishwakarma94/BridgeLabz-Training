//Created class Named SimpleInterest
import java.util.Scanner;
public class SimpleInterest{
   public static void main(String[]args){

    //take input for principal, rate and time
    Scanner input=new Scanner(System.in);
    double principal=input.nextDouble();
    double rate=input.nextDouble();
    double time=input.nextDouble();
    double si=calculateSimpleInterest(principal,rate,time);

    //Print the simple interest
    System.out.println("The Simple Interest is " + si + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
   }

   //method to calculate simple interest
   public static double calculateSimpleInterest(double principal,double rate,double time){
       return (principal*rate*time)/100;
   }
}