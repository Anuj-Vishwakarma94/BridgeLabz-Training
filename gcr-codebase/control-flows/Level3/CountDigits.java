//Created class Named CountDigits
import java.util.Scanner;
public class CountDigits{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int count=0;

    //use loop to count number of digits
    while(number!=0){
        number=number/10;
        count++;
    }

    //print the count of digits
    System.out.println(count);
   }
}
