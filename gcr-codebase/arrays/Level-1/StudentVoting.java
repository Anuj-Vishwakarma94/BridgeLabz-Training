//Created class Named StudentVoting
import java.util.Scanner;
public class StudentVoting{
   public static void main(String[]args){

    //take input for the age of 10 students
    Scanner input=new Scanner(System.in);
    int ages[]=new int[10];

    for(int i=0;i<ages.length;i++){
        ages[i]=input.nextInt();
    }

    //check voting eligibility of each student
    for(int i=0;i<ages.length;i++){
        if(ages[i]<0){
            System.out.println("Invalid age");
        }
        else if(ages[i]>=18){
            System.out.println("The student with the age " + ages[i] + " can vote");
        }
        else{
            System.out.println("The student with the age " + ages[i] + " cannot vote");
        }
    }
   }
}
