//Created class Named MultiplesOfNumber
import java.util.Scanner;
public class MultiplesOfNumber{
   public static void main(String[]args){

    //take input from the user and check whether it is positive and less than 100
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0 || number>=100){
        System.out.println("Please enter a positive number less than 100");
    }
    else{

        //use for loop backward to find multiples below 100
        for(int i=100;i>=1;i--){
            if(i%number==0){
                System.out.println(i);
            }
        }
    }
   }
}
