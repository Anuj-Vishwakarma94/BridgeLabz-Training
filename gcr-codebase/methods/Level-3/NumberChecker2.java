//Created class Named NumberChecker2
import java.util.Scanner;
public class NumberChecker2{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number
    int number=input.nextInt();

    int count=countDigits(number);
    int digits[]=storeDigits(number,count);

    System.out.println("Count of digits = " + count);

    int sum=findSumOfDigits(digits);
    System.out.println("Sum of digits = " + sum);

    double sumOfSquares=findSumOfSquaresOfDigits(digits);
    System.out.println("Sum of squares of digits = " + sumOfSquares);

    //check harshad number
    if(isHarshadNumber(number,digits)){
        System.out.println("Harshad Number");
    }
    else{
        System.out.println("Not a Harshad Number");
    }

    int frequency[][]=findDigitFrequency(digits);

    //display frequency of digits
    for(int i=0;i<frequency.length;i++){
        System.out.println("Digit " + frequency[i][0] + " Frequency " + frequency[i][1]);
    }
   }

   //method to find count of digits
   public static int countDigits(int number){
       int count=0;

       while(number!=0){
           count++;
           number=number/10;
       }

       return count;
   }

   //method to store digits in array
   public static int[] storeDigits(int number,int count){
       int digits[]=new int[count];
       int index=0;

       while(number!=0){
           digits[index]=number%10;
           number=number/10;
           index++;
       }

       return digits;
   }

   //method to find sum of digits
   public static int findSumOfDigits(int digits[]){
       int sum=0;

       for(int i=0;i<digits.length;i++){
           sum=sum+digits[i];
       }

       return sum;
   }

   //method to find sum of squares of digits
   public static double findSumOfSquaresOfDigits(int digits[]){
       double sum=0;

       for(int i=0;i<digits.length;i++){
           sum=sum+Math.pow(digits[i],2);
       }

       return sum;
   }

   //method to check harshad number
   public static boolean isHarshadNumber(int number,int digits[]){
       int sum=findSumOfDigits(digits);

       if(sum!=0 && number%sum==0){
           return true;
       }
       else{
           return false;
       }
   }

   //method to find frequency of each digit
   public static int[][] findDigitFrequency(int digits[]){
       int frequency[][]=new int[10][2];

       for(int i=0;i<10;i++){
           frequency[i][0]=i;
           frequency[i][1]=0;
       }

       for(int i=0;i<digits.length;i++){
           frequency[digits[i]][1]++;
       }

       return frequency;
   }
}
