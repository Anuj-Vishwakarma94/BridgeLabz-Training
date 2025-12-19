//Created class Named MeanHeight
import java.util.Scanner;
public class MeanHeight{
   public static void main(String[]args){

    //take input from the user for height of 11 players
    Scanner input=new Scanner(System.in);
    double heights[]=new double[11];

    double sum=0.0;

    for(int i=0;i<heights.length;i++){
        heights[i]=input.nextDouble();
        sum=sum+heights[i];
    }

    //calculate and print mean height
    double mean=sum/11;
    System.out.println(mean);
   }
}
