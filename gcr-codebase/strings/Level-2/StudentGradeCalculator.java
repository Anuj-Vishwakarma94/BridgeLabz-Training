//Created class Named StudentGradeCalculator
import java.util.Scanner;
public class StudentGradeCalculator{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number of students
    int students=input.nextInt();

    //generate random PCM scores for students
    int pcmScores[][]=generateRandomPCMScores(students);

    //calculate total, average and percentage
    double results[][]=calculateResults(pcmScores);

    //calculate grade and remarks
    String gradeRemarks[][]=calculateGradeAndRemarks(results);

    //display scorecard in tabular format
    displayScoreCard(pcmScores,results,gradeRemarks);
   }

   //method to generate random 2-digit PCM scores
   public static int[][] generateRandomPCMScores(int students){
       int scores[][]=new int[students][3];

       for(int i=0;i<students;i++){
           scores[i][0]=(int)(Math.random()*90)+10; 
           scores[i][1]=(int)(Math.random()*90)+10; 
           scores[i][2]=(int)(Math.random()*90)+10; 
       }

       return scores;
   }

   //method to calculate total, average and percentage
   public static double[][] calculateResults(int scores[][]){
       double result[][]=new double[scores.length][3];

       for(int i=0;i<scores.length;i++){

           //calculate total marks
           int total=scores[i][0]+scores[i][1]+scores[i][2];

           //calculate average marks
           double average=total/3.0;

           //calculate percentage
           double percentage=(total/300.0)*100;

           //round off values to 2 decimal places
           average=Math.round(average*100.0)/100.0;
           percentage=Math.round(percentage*100.0)/100.0;

           result[i][0]=total;
           result[i][1]=average;
           result[i][2]=percentage;
       }

       return result;
   }

   //method to calculate grade and remarks based on percentage
   public static String[][] calculateGradeAndRemarks(double results[][]){
       String gradeRemarks[][]=new String[results.length][2];

       for(int i=0;i<results.length;i++){
           double percentage=results[i][2];

           if(percentage>=80){
               gradeRemarks[i][0]="A";
               gradeRemarks[i][1]="Level 4, above agency-normalized standards";
           }
           else if(percentage>=70){
               gradeRemarks[i][0]="B";
               gradeRemarks[i][1]="Level 3, at agency-normalized standards";
           }
           else if(percentage>=60){
               gradeRemarks[i][0]="C";
               gradeRemarks[i][1]="Level 2, below but approaching standards";
           }
           else if(percentage>=50){
               gradeRemarks[i][0]="D";
               gradeRemarks[i][1]="Level 1, well below standards";
           }
           else if(percentage>=40){
               gradeRemarks[i][0]="E";
               gradeRemarks[i][1]="Level 1-, too below standards";
           }
           else{
               gradeRemarks[i][0]="R";
               gradeRemarks[i][1]="Remedial standards";
           }
       }

       return gradeRemarks;
   }

   //method to display scorecard in proper tabular format
   public static void displayScoreCard(int scores[][],double results[][],String gradeRemarks[][]){

       System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade\tRemarks");

       for(int i=0;i<scores.length;i++){
           System.out.println(scores[i][0] + "\t" +
                              scores[i][1] + "\t" +
                              scores[i][2] + "\t" +
                              (int)results[i][0] + "\t" +
                              results[i][1] + "\t" +
                              results[i][2] + "\t" +
                              gradeRemarks[i][0] + "\t" +
                              gradeRemarks[i][1]);
       }
   }
}