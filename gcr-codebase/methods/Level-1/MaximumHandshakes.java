//Created class Named MaximumHandshakes
import java.util.Scanner;
public class MaximumHandshakes{
   public static void main(String[]args){

    //take input for numberOfStudents
    Scanner input=new Scanner(System.in);
    int numberOfStudents=input.nextInt();
    int handshake=numberOfHandshakes(numberOfStudents);

    //Print the number of Handshakes
    System.out.println("The Number of Possible Handshakes : "+ );
   }

   //method to calculate the required number of handshakes
   public static int numberOfHandshakes(int numberOfStudents){
       return (numberOfStudents*(numberOfStudents-1))/2;
   }
}