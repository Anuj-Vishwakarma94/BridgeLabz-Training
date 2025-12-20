//Created class Named StudentGradeCalculation
import java.util.Scanner;
public class StudentGradeCalculation{
   public static void main(String[]args){

    //take input for number of students
    Scanner input=new Scanner(System.in);
    int students=input.nextInt();

    int physics[]=new int[students];
    int chemistry[]=new int[students];
    int maths[]=new int[students];
    double percentage[]=new double[students];
    char grade[]=new char[students];
    String remark[]=new String[students];

    //take input for marks of students
    for(int i=0;i<students;i++){
        int p=input.nextInt();
        int c=input.nextInt();
        int m=input.nextInt();

        if(p<0 || c<0 || m<0){
            System.out.println("Invalid marks, enter again");
            i--;
        }
        else{
            physics[i]=p;
            chemistry[i]=c;
            maths[i]=m;
        }
    }

    //calculate percentage, grade and remark
    for(int i=0;i<students;i++){
        percentage[i]=(physics[i]+chemistry[i]+maths[i])/3.0;

        if(percentage[i]>=80){
            grade[i]='A';
            remark[i]="Level 4, above agency-normalized standards";
        }
        else if(percentage[i]>=70){
            grade[i]='B';
            remark[i]="Level 3, at agency-normalized standards";
        }
        else if(percentage[i]>=60){
            grade[i]='C';
            remark[i]="Level 2, below but approaching agency-normalized standards";
        }
        else if(percentage[i]>=50){
            grade[i]='D';
            remark[i]="Level 1, well below agency-normalized standards";
        }
        else if(percentage[i]>=40){
            grade[i]='E';
            remark[i]="Level 1-, too below agency-normalized standards";
        }
        else{
            grade[i]='R';
            remark[i]="Remedial standards";
        }
    }

    //Print marks, percentage, grade and remark of each student
    for(int i=0;i<students;i++){
        System.out.println("Physics: " + physics[i]);
        System.out.println("Chemistry: " + chemistry[i]);
        System.out.println("Maths: " + maths[i]);
        System.out.println("Percentage: " + percentage[i]);
        System.out.println("Grade: " + grade[i]);
        System.out.println("Remark: " + remark[i]);
    }
   }
}
