//Created class Named MultiplicationTable
import java.util.Scanner;
public class MultiplicationTable{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int table[]=new int[10];

    //use for loop to store multiplication results
    for(int i=1;i<=10;i++){
        table[i-1]=number*i;
    }

    // the multiplication table
    for(int i=1;i<=10;i++){
        System.out.println(number + " * " + i + " = " + table[i-1]);
    }
   }
}
