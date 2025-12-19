//Created class Named AgeAndHeight
import java.util.Scanner;
public class AgeAndHeight{
   public static void main(String[]args){

    //take age and height of Amar, Akbar and Anthony from the user
    Scanner input=new Scanner(System.in);
    int amarAge=input.nextInt();
    int akbarAge=input.nextInt();
    int anthonyAge=input.nextInt();
    double amarHeight=input.nextDouble();
    double akbarHeight=input.nextDouble();
    double anthonyHeight=input.nextDouble();

    //find the youngest friend
    if(amarAge<=akbarAge && amarAge<=anthonyAge){
        System.out.println("Amar is the youngest");
    }
    else if(akbarAge<=amarAge && akbarAge<=anthonyAge){
        System.out.println("Akbar is the youngest");
    }
    else{
        System.out.println("Anthony is the youngest");
    }

    //find the tallest friend
    if(amarHeight>=akbarHeight && amarHeight>=anthonyHeight){
        System.out.println("Amar is the tallest");
    }
    else if(akbarHeight>=amarHeight && akbarHeight>=anthonyHeight){
        System.out.println("Akbar is the tallest");
    }
    else{
        System.out.println("Anthony is the tallest");
    }
   }
}
