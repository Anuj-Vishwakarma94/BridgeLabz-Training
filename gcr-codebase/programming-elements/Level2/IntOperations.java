//Created class named IntOperations
import java.util.Scanner;
public class IntOperations{
    public static void main(String args[]){
	
	//take a,b,c as input from the user and calculate operation1,operation2,operation3 and operation4
	Scanner input=new Scanner(System.in);
	int a=input.nextInt();
	int b=input.nextInt();
	int c=input.nextInt();
	int operation1=a+b*c;
	int operation2=a*b+c;
	int operation3=c+a/b;
	int operation4=a%b+c;
	  
	//print the value of all the operations
	System.out.println("The results of Int Operations are "+operation1+", "+operation2+", "+operation3+" and "+operation4);
	}
}