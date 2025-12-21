//Created class Named FriendsAgeHeight
import java.util.Scanner;
public class FriendsAgeHeight{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for age and height of 3 friends
    int age[]=new int[3];
    double height[]=new double[3];

    for(int i=0;i<3;i++){
        age[i]=input.nextInt();
        height[i]=input.nextDouble();
    }

    int youngestIndex=findYoungest(age);
    int tallestIndex=findTallest(height);

    //display youngest friend
    if(youngestIndex==0){
        System.out.println("Amar is the youngest");
    }
    else if(youngestIndex==1){
        System.out.println("Akbar is the youngest");
    }
    else{
        System.out.println("Anthony is the youngest");
    }

    //display tallest friend
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

   //method to find youngest friend
   public static int findYoungest(int age[]){
       int index=0;

       for(int i=1;i<age.length;i++){
           if(age[i]<age[index]){
               index=i;
           }
       }

       return index;
   }

   //method to find tallest friend
   public static int findTallest(double height[]){
       int index=0;

       for(int i=1;i<height.length;i++){
           if(height[i]>height[index]){
               index=i;
           }
       }

       return index;
   }
}
