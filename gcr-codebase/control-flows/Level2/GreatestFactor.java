//Created class Named GreatestFactor
import java.util.Scanner;
public class GreatestFactor{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=1){
        System.out.println("No factors possible");
    }
    else{
        int greatestFactor=1;

        //use for loop to find greatest factor beside itself
        for(int i=number-1;i>=1;i--){
            if(number%i==0){
                greatestFactor=i;
                break;
            }
        }

        //print the greatest factor
        System.out.println(greatestFactor);
    }
   }
}
