//Created class Named NumberChecker
import java.util.Scanner;
public class NumberChecker{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number
    int number=input.nextInt();

    int count=countDigits(number);
    int digits[]=storeDigits(number,count);

    System.out.println("Count of digits = " + count);

    //check duck number
    if(isDuckNumber(digits)){
        System.out.println("Duck Number");
    }
    else{
        System.out.println("Not a Duck Number");
    }

    //check armstrong number
    if(isArmstrong(number,digits)){
        System.out.println("Armstrong Number");
    }
    else{
        System.out.println("Not an Armstrong Number");
    }

    int largestSecond[]=findLargestSecondLargest(digits);
    int smallestSecond[]=findSmallestSecondSmallest(digits);

    System.out.println("Largest = " + largestSecond[0]);
    System.out.println("Second Largest = " + largestSecond[1]);

    System.out.println("Smallest = " + smallestSecond[0]);
    System.out.println("Second Smallest = " + smallestSecond[1]);
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

   //method to check duck number
   public static boolean isDuckNumber(int digits[]){
       for(int i=0;i<digits.length;i++){
           if(digits[i]!=0){
               return true;
           }
       }
       return false;
   }

   //method to check armstrong number
   public static boolean isArmstrong(int number,int digits[]){
       int sum=0;
       int power=digits.length;

       for(int i=0;i<digits.length;i++){
           sum=sum+(int)Math.pow(digits[i],power);
       }

       if(sum==number){
           return true;
       }
       else{
           return false;
       }
   }

   //method to find largest and second largest
   public static int[] findLargestSecondLargest(int digits[]){
       int largest=Integer.MIN_VALUE;
       int secondLargest=Integer.MIN_VALUE;

       for(int i=0;i<digits.length;i++){
           if(digits[i]>largest){
               secondLargest=largest;
               largest=digits[i];
           }
           else if(digits[i]>secondLargest && digits[i]!=largest){
               secondLargest=digits[i];
           }
       }

       return new int[]{largest,secondLargest};
   }

   //method to find smallest and second smallest
   public static int[] findSmallestSecondSmallest(int digits[]){
       int smallest=Integer.MAX_VALUE;
       int secondSmallest=Integer.MAX_VALUE;

       for(int i=0;i<digits.length;i++){
           if(digits[i]<smallest){
               secondSmallest=smallest;
               smallest=digits[i];
           }
           else if(digits[i]<secondSmallest && digits[i]!=smallest){
               secondSmallest=digits[i];
           }
       }

       return new int[]{smallest,secondSmallest};
   }
}
