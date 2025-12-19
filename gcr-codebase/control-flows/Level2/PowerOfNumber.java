//Created class Named PowerOfNumber
import java.util.Scanner;
public class PowerOfNumber{
   public static void main(String[]args){

    //take input from the user and check whether they are positive integers
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    int power=input.nextInt();

    if(number<=0 || power<=0){
        System.out.println("Please enter positive integers");
    }
    else{
        int result=1;

        //use for loop to calculate power of the number
        for(int i=1;i<=power;i++){
            result=result*number;
        }

        //print the result
        System.out.println(result);
    }
   }
}
