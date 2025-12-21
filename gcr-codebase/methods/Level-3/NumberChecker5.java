//Created class Named NumberChecker5
import java.util.Scanner;
public class NumberChecker5{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number
    int number=input.nextInt();

    //check perfect number
    if(isPerfectNumber(number)){
        System.out.println("Perfect Number");
    }
    else{
        System.out.println("Not a Perfect Number");
    }

    //check abundant number
    if(isAbundantNumber(number)){
        System.out.println("Abundant Number");
    }
    else{
        System.out.println("Not an Abundant Number");
    }

    //check deficient number
    if(isDeficientNumber(number)){
        System.out.println("Deficient Number");
    }
    else{
        System.out.println("Not a Deficient Number");
    }

    //check strong number
    if(isStrongNumber(number)){
        System.out.println("Strong Number");
    }
    else{
        System.out.println("Not a Strong Number");
    }
   }

   //method to check perfect number
   public static boolean isPerfectNumber(int number){
       int sum=0;

       for(int i=1;i<=number/2;i++){
           if(number%i==0){
               sum=sum+i;
           }
       }

       if(sum==number && number>0){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check abundant number
   public static boolean isAbundantNumber(int number){
       int sum=0;

       for(int i=1;i<=number/2;i++){
           if(number%i==0){
               sum=sum+i;
           }
       }

       if(sum>number){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check deficient number
   public static boolean isDeficientNumber(int number){
       int sum=0;

       for(int i=1;i<=number/2;i++){
           if(number%i==0){
               sum=sum+i;
           }
       }

       if(sum<number){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check strong number
   public static boolean isStrongNumber(int number){
       int sum=0;
       int temp=number;

       while(temp!=0){
           int digit=temp%10;
           sum=sum+findFactorial(digit);
           temp=temp/10;
       }

       if(sum==number){
           return true;
       }
       else{
           return false;
       }
   }

   //method to find factorial of a digit
   public static int findFactorial(int digit){
       int fact=1;

       for(int i=1;i<=digit;i++){
           fact=fact*i;
       }

       return fact;
   }
}
