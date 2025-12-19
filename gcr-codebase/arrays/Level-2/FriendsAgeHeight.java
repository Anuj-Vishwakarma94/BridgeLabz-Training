//Created class Named FriendsAgeHeight
import java.util.Scanner;
public class FriendsAgeHeight{
   public static void main(String[]args){

    //take input for age and height of 3 friends
    Scanner input=new Scanner(System.in);
    int age[]=new int[3];
    double height[]=new double[3];

    for(int i=0;i<3;i++){
        age[i]=input.nextInt();
        height[i]=input.nextDouble();
    }

    int youngestIndex=0;
    int tallestIndex=0;

    //find the youngest and tallest friend
    for(int i=1;i<3;i++){
        if(age[i]<age[youngestIndex]){
            youngestIndex=i;
        }
        if(height[i]>height[tallestIndex]){
            tallestIndex=i;
        }
    }

    //display the youngest friend
    if(youngestIndex==0){
        System.out.println("Amar is the youngest");
    }
    else if(youngestIndex==1){
        System.out.println("Akbar is the youngest");
    }
    else{
        System.out.println("Anthony is the youngest");
    }

    //display the tallest friend
    if(tallestIndex==0){
        System.out.println("Amar is the tallest");
    }
    else if(tallestIndex==1){
        System.out.println("Akbar is the tallest");
    }
    else{
        System.out.println("Anthony is the tallest");
    }
   }
}
