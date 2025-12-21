//Created class Named StudentScoreCard
import java.util.Scanner;
public class StudentScoreCard{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number of students
    int students=input.nextInt();

    double pcmScores[][]=generatePCMScores(students);
    double results[][]=calculateResults(pcmScores);
    String gradeRemark[][]=calculateGradeAndRemark(results);

    //display scorecard
    displayScoreCard(pcmScores,results,gradeRemark);
   }

   //method to generate random PCM scores
   public static double[][] generatePCMScores(int students){
       double scores[][]=new double[students][3];

       for(int i=0;i<students;i++){
           scores[i][0]=(int)(Math.random()*90)+10; //Physics
           scores[i][1]=(int)(Math.random()*90)+10; //Chemistry
           scores[i][2]=(int)(Math.random()*90)+10; //Maths
       }

       return scores;
   }

   //method to calculate total, average and percentage
   public static double[][] calculateResults(double scores[][]){
       double result[][]=new double[scores.length][3];

       for(int i=0;i<scores.length;i++){
           double total=scores[i][0]+scores[i][1]+scores[i][2];
           double average=total/3;
           double percentage=(total/300)*100;

           result[i][0]=Math.round(total*100.0)/100.0;
           result[i][1]=Math.round(average*100.0)/100.0;
           result[i][2]=Math.round(percentage*100.0)/100.0;
       }

       return result;
   }

   //method to calculate grade and remark
   public static String[][] calculateGradeAndRemark(double result[][]){
       String gradeRemark[][]=new String[result.length][2];

       for(int i=0;i<result.length;i++){
           double percentage=result[i][2];

           if(percentage>=80){
               gradeRemark[i][0]="A";
               gradeRemark[i][1]="Above agency-normalized standards";
           }
           else if(percentage>=70){
               gradeRemark[i][0]="B";
               gradeRemark[i][1]="At agency-normalized standards";
           }
           else if(percentage>=60){
               gradeRemark[i][0]="C";
               gradeRemark[i][1]="Below but approaching standards";
           }
           else if(percentage>=50){
               gradeRemark[i][0]="D";
               gradeRemark[i][1]="Well below standards";
           }
           else if(percentage>=40){
               gradeRemark[i][0]="E";
               gradeRemark[i][1]="Too below standards";
           }
           else{
               gradeRemark[i][0]="R";
               gradeRemark[i][1]="Remedial standards";
           }
       }

       return gradeRemark;
   }

   //method to display scorecard
   public static void displayScoreCard(double scores[][],double result[][],String gradeRemark[][]){

       System.out.println("Stud\tPhysics\t\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade\tRemark");

       for(int i=0;i<scores.length;i++){
           System.out.println((i+1) + "\t" +
                              scores[i][0] + "\t\t" +
                              scores[i][1] + "\t\t" +
                              scores[i][2] + "\t" +
                              result[i][0] + "\t" +
                              result[i][1] + "\t" +
                              result[i][2] + "\t\t" +
                              gradeRemark[i][0] + "\t" +
                              gradeRemark[i][1]);
       }
   }
}
