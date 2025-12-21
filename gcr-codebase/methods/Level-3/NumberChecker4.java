//Created class Named NumberChecker4
import java.util.Scanner;
public class NumberChecker4{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number
    int number=input.nextInt();

    //check prime number
    if(isPrime(number)){
        System.out.println("Prime Number");
    }
    else{
        System.out.println("Not a Prime Number");
    }

    //check neon number
    if(isNeonNumber(number)){
        System.out.println("Neon Number");
    }
    else{
        System.out.println("Not a Neon Number");
    }

    //check spy number
    if(isSpyNumber(number)){
        System.out.println("Spy Number");
    }
    else{
        System.out.println("Not a Spy Number");
    }

    //check automorphic number
    if(isAutomorphicNumber(number)){
        System.out.println("Automorphic Number");
    }
    else{
        System.out.println("Not an Automorphic Number");
    }

    //check buzz number
    if(isBuzzNumber(number)){
        System.out.println("Buzz Number");
    }
    else{
        System.out.println("Not a Buzz Number");
    }
   }

   //method to check prime number
   public static boolean isPrime(int number){
       if(number<=1){
           return false;
       }

       for(int i=2;i<=number/2;i++){
           if(number%i==0){
               return false;
           }
       }

       return true;
   }

   //method to check neon number
   public static boolean isNeonNumber(int number){
       int square=number*number;
       int sum=0;

       while(square!=0){
           sum=sum+(square%10);
           square=square/10;
       }

       if(sum==number){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check spy number
   public static boolean isSpyNumber(int number){
       int sum=0;
       int product=1;
       int temp=number;

       while(temp!=0){
           int digit=temp%10;
           sum=sum+digit;
           product=product*digit;
           temp=temp/10;
       }

       if(sum==product){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check automorphic number
   public static boolean isAutomorphicNumber(int number){
       int square=number*number;
       int temp=number;

       while(temp!=0){
           if(square%10!=temp%10){
               return false;
           }
           square=square/10;
           temp=temp/10;
       }

       return true;
   }

   //method to check buzz number
   public static boolean isBuzzNumber(int number){
       if(number%7==0 || number%10==7){
           return true;
       }
       else{
           return false;
       }
   }
}
