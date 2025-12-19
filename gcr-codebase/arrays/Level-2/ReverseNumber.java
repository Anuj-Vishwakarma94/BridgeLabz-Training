//Created class Named ReverseNumber
import java.util.Scanner;
public class ReverseNumber{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int temp=number;
    int count=0;

    //find the count of digits
    while(temp!=0){
        temp=temp/10;
        count++;
    }

    int digits[]=new int[count];
    temp=number;

    //store digits of the number in array
    for(int i=0;i<count;i++){
        digits[i]=temp%10;
        temp=temp/10;
    }

    int reverseDigits[]=new int[count];

    //store digits in reverse order
    for(int i=0;i<count;i++){
        reverseDigits[i]=digits[count-1-i];
    }

    //Print the reversed number
    for(int i=0;i<count;i++){
        System.out.print(reverseDigits[i]);
    }
   }
}
