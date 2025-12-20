//Created class Named SumOfNaturalNumbers
import java.util.Scanner;
public class SumOfNaturalNumbers{
   public static void main(String[]args){

    //take number as input
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    int result=sum(number);

    //Print the sum of natural numbers
    System.out.println(result);
   }

   //method to calculate the sum 
   public static int sum(int number){
       int sum=0;
       for(int i=1;i<=number;i++){
             sum=sum+i;
       }
       return sum;
   }
}