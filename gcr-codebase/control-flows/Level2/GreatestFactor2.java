//Created class Named GreatestFactor2
import java.util.Scanner;
public class GreatestFactor2{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=1){
        System.out.println("No factors possible");
    }
    else{
        int greatestFactor=1;
        int counter=number-1;

        //use while loop to find greatest factor beside itself
        while(counter>=1){
            if(number%counter==0){
                greatestFactor=counter;
                break;
            }
            counter--;
        }

        //print the greatest factor
        System.out.println(greatestFactor);
    }
   }
}
