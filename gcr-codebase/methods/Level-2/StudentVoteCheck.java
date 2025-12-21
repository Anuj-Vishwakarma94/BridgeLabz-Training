//Created class Named StudentVoteCheck
import java.util.Scanner;
public class StudentVoteCheck{
   public static void main(String[]args){

    //take input for age of 10 students
    Scanner input=new Scanner(System.in);
    int age[]=new int[10];

    StudentVoteCheck obj=new StudentVoteCheck();

    for(int i=0;i<age.length;i++){
        age[i]=input.nextInt();

        boolean result=obj.canStudentVote(age[i]);

        if(result){
            System.out.println("The student with the age " + age[i] + " can vote");
        }
        else{
            System.out.println("The student with the age " + age[i] + " cannot vote");
        }
    }
   }

   //method to check whether student can vote
   public boolean canStudentVote(int age){
       if(age>=18){
           return true;
       }
       else{
           return false;
       }
   }
}
