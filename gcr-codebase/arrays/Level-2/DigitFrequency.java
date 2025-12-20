//Created class Named 

import java.util.Scanner;
public class DigitFrequency{
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
    int frequency[]=new int[10];

    //find frequency of each digit
    for(int i=0;i<count;i++){
        frequency[digits[i]]++;
    }

    //Print the frequency of each digit
    for(int i=0;i<10;i++){
        if(frequency[i]>0){
            System.out.println("Digit " + i + " frequency = " + frequency[i]);
        }
    }
   }
}
