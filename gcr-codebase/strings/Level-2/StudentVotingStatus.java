//Created class Named StudentVotingStatus
import java.util.Scanner;
public class StudentVotingStatus{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number of students
    int students=input.nextInt();

    //generate random ages for students
    int ages[]=generateRandomAges(students);

    //check voting eligibility
    String result[][]=checkVotingEligibility(ages);

    //display result in tabular format
    displayVotingStatus(result);
   }

   //method to generate random 2-digit ages
   public static int[] generateRandomAges(int students){
       int ages[]=new int[students];

       for(int i=0;i<students;i++){
           //random age between 10 and 99
           ages[i]=(int)(Math.random()*90)+10;
       }

       return ages;
   }

   //method to check voting eligibility
   public static String[][] checkVotingEligibility(int ages[]){
       String table[][]=new String[ages.length][2];

       for(int i=0;i<ages.length;i++){
           table[i][0]=String.valueOf(ages[i]);

           if(ages[i]<0){
               table[i][1]="false";
           }
           else if(ages[i]>=18){
               table[i][1]="true";
           }
           else{
               table[i][1]="false";
           }
       }

       return table;
   }

   //method to display 2D array in tabular format
   public static void displayVotingStatus(String table[][]){

       System.out.println("Age\tCan Vote");

       for(int i=0;i<table.length;i++){
           System.out.println(table[i][0] + "\t" + table[i][1]);
       }
   }
}
