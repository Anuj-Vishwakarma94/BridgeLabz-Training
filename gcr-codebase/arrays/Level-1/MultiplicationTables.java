//Created class Named MultiplicationTables
import java.util.Scanner;
public class MultiplicationTables{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    //use for loop to print multiplication table from 6 to 9
    for(int i=6;i<=9;i++){
        System.out.println(number + " * " + i + " = " + (number*i));
    }
   }
}
