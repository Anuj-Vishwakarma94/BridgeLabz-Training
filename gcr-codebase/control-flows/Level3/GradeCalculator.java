//Created class Named GradeCalculator
import java.util.Scanner;
public class GradeCalculator{
   public static void main(String[]args){

    //take marks of physics ,chemistry and maths as input from the user and check whether the year is valid
    Scanner input=new Scanner(System.in);
    int physics=input.nextInt();
	int chemistry=input.nextInt();
	int maths=input.nextInt();
    int average=(physics+chemistry+maths)/3;
	
    if(average>=80){
        System.out.println("Average Mark : "+average);
		System.out.println("Grade : A");
		System.out.println("Remark : Level 4, above agency-normalized standards");
		
    }
	else if(average>=70 && average<=79){
	    System.out.println("Average Mark : "+average);
		System.out.println("Grade : B");
		System.out.println("Remark : Level 3,at agency-normalized standards");		
    }
	else if(average>=60 && average<=69){
	    System.out.println("Average Mark : "+average);
		System.out.println("Grade : C");
		System.out.println("Remark : Level 2,below, but approaching agency-normalized standards");
	}
    else if(average>=50 && average<=59){
	    System.out.println("Average Mark : "+average);
		System.out.println("Grade : D");
		System.out.println("Remark : Level 1, well below agency-normalized standards");
	}
    else if(average>=40 && average<=49){
	    System.out.println("Average Mark : "+average);
		System.out.println("Grade : E");
		System.out.println("Remark : Level 1-, too below agency-normalized standards");
	}
    else{
	    System.out.println("Average Mark : "+average);
		System.out.println("Grade : R");
		System.out.println("Remark : Remedial standards");
	}
   }
}