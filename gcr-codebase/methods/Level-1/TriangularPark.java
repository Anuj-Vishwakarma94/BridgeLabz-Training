//Created class Named TriangularPark
import java.util.Scanner;
public class TriangularPark{
   public static void main(String[]args){

    //take input for the sides of triangle
    Scanner input=new Scanner(System.in);
    int side1=input.nextInt();
    int side2=input.nextInt();
    int side3=input.nextInt();
    int rounds=numberOfRounds(side1,side2,side3);

    //Print the number of rounds
    System.out.println("The number of rounds required to complete 5km is : "+rounds );
   }

   //method to calculate the number of rounds required
   public static int numberOfRounds(int side1,int side2,int side3){
       if((side1+side2+side3)%5000==0){
       return 5000/(side1+side2+side3);
       }
       else{
       return 5000/(side1+side2+side3)+1;
       }
   }
}