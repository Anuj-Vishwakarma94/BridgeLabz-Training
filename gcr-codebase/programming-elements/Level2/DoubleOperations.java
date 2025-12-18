//Created class named DoubleOperations
import java.util.Scanner;
public class DoubleOperations{
    public static void main(String args[]){
	
	//take a,b,c as input from the user and calculate operation1,operation2,operation3 and operation4
	Scanner input=new Scanner(System.in);
	double a=input.nextDouble();
	double b=input.nextDouble();
	double c=input.nextDouble();
	double operation1=a+b*c;
	double operation2=a*b+c;
	double operation3=c+a/b;
	double operation4=a%b+c;
	  
	//print the value of all the operations
	System.out.println("The results of Double Operations are "+operation1+", "+operation2+", "+operation3+" and "+operation4);
	}
}