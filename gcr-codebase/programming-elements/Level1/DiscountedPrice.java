//Created class Named DiscountedPrice
public class DiscountedPrice{
  public static void main(String[]args){
        
	//take fee and discount percent as the input and calculate the final discountedfee 
	int fee=125000;
  int discountPercent=10;
  int discount=fee*discountPercent/100;
  int finaldiscountedfee=fee-discount;
        
	//print the discount and final discount fee in INR
	System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+finaldiscountedfee);
  }
}