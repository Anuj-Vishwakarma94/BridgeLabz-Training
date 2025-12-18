//Created class Named CalculateTotalPrice
import java.util.Scanner;
public class CalculateTotalPrice{
    public static void main(String args[]){
		
	//take unitPrice and Quantity as input from user then calculate the totalPrice	
	Scanner input=new Scanner(System.in);
	int unitPrice=input.nextInt();
	int quantity=input.nextInt();
	int totalPrice=(unitPrice*quantity);
	 
	//print the totalPrice,quantity and unitPrice in INR
	System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
	}
}