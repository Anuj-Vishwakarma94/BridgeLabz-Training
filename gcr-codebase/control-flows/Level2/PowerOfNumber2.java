//Created class Named PowerOfNumber2
import java.util.Scanner;
public class PowerOfNumber2{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    int power=input.nextInt();

    if(number<=0 || power<=0){
        System.out.println("Please enter positive integers");
    }
    else{
        int result=1;
        int counter=0;

        //use while loop to calculate power of the number
        while(counter<power){
            result=result*number;
            counter++;
        }

        //print the result
        System.out.println(result);
    }
   }
}
