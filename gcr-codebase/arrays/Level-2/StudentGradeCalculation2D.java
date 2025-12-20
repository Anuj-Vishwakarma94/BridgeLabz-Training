//Created class Named StudentGradeCalculation2D
import java.util.Scanner;
public class StudentGradeCalculation2D{
   public static void main(String[]args){

    //take input for number of students
    Scanner input=new Scanner(System.in);
    int students=input.nextInt();

    int marks[][]=new int[students][3];
    double percentage[]=new double[students];
    char grade[]=new char[students];
    String remark[]=new String[students];

    //take input for marks of students (physics, chemistry, maths)
    for(int i=0;i<students;i++){
        int p=input.nextInt();
        int c=input.nextInt();
        int m=input.nextInt();

        if(p<0 || c<0 || m<0){
            System.out.println("Invalid marks, enter again");
            i--;
        }
        else{
            marks[i][0]=p;
            marks[i][1]=c;
            marks[i][2]=m;
        }
    }

    //calculate percentage, grade and remark using 2D array
    for(int i=0;i<students;i++){
        percentage[i]=(marks[i][0]+marks[i][1]+marks[i][2])/3.0;

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

    //Print percentage, grade and remark of each student
    for(int i=0;i<students;i++){
        System.out.println("Physics: " + marks[i][0]);
        System.out.println("Chemistry: " + marks[i][1]);
        System.out.println("Maths: " + marks[i][2]);
        System.out.println("Percentage: " + percentage[i]);
        System.out.println("Grade: " + grade[i]);
        System.out.println("Remark: " + remark[i]);
    }
   }
}
