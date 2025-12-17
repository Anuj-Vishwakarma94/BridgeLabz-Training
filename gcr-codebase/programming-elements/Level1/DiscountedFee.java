//Created class Named DiscountedFee
import java.util.Scanner;
public class DiscountedFee{
    public static void main(String[]args){
	
	//take fee and discount percent as the input from the user and calculate the final discountedfee 
	Scanner input=new Scanner(System.in);
    int fee=input.nextInt();
    int discountPercent=input.nextInt();
    int discount=fee*discountPercent/100;
    int finaldiscountedfee=fee-discount;
        
    //print the discount and final discount fee in INR
	System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+finaldiscountedfee);
    }
}