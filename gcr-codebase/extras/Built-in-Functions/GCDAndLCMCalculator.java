// Created class named GCDAndLCMCalculator
import java.util.Scanner;
public class GCDAndLCMCalculator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num1=input.nextInt();
        int num2=input.nextInt();
        int gcd=calculateGCD(num1,num2);
        int lcm=calculateLCM(num1,num2);
        
		//display the Gcd and Lcm 
		System.out.println("GCD is: " + gcd);
        System.out.println("LCM is: " + lcm);
    }
	
	//method to calculateGCD
    public static int calculateGCD(int a, int b){
        while(b!=0) {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
	
	//method to calculateLCM
    public static int calculateLCM(int a, int b){
        return(a*b)/calculateGCD(a,b);
    }
}
