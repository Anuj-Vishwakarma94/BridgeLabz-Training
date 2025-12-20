//Created class Named SmallestAndLargest
import java.util.Scanner;
public class SmallestAndLargest{
   public static void main(String[]args){

    //take input for three numbers
    Scanner input=new Scanner(System.in);
    int number1=input.nextInt();
    int number2=input.nextInt();
    int number3=input.nextInt();

    int result[]=findSmallestAndLargest(number1,number2,number3);

    //display the smallest and largest numbers
    System.out.println("Smallest number = " + result[0]);
    System.out.println("Largest number = " + result[1]);
   }

   //method to find smallest and largest number
   public static int[] findSmallestAndLargest(int number1,int number2,int number3){
       int smallest=number1;
       int largest=number1;

       if(number2<smallest){
           smallest=number2;
       }
       if(number3<smallest){
           smallest=number3;
       }

       if(number2>largest){
           largest=number2;
       }
       if(number3>largest){
           largest=number3;
       }

       return new int[]{smallest,largest};
   }
}
