//Created class Named LargestDigit
import java.util.Scanner;
public class LargestDigit{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int maxDigit=10;
    int digits[]=new int[maxDigit];
    int index=0;

    //store digits of the number in the array
    while(number!=0){
        if(index==maxDigit){
            break;
        }
        digits[index]=number%10;
        number=number/10;
        index++;
    }

    int largest=0;
    int secondLargest=0;

    //find largest and second largest digit
    for(int i=0;i<index;i++){
        if(digits[i]>largest){
            secondLargest=largest;
            largest=digits[i];
        }
        else if(digits[i]>secondLargest && digits[i]<largest){
            secondLargest=digits[i];
        }
    }

    //print the largest and second largest digit
    System.out.println("Largest digit = " + largest);
    System.out.println("Second largest digit = " + secondLargest);
   }
}
