//Created class named ProfitLossPercentage
public class ProfitLossPercentage{
    public static void main(String args[]){
	
	//take cost Price and selling Price as the input and then calculate its profit and profit percentage
	double costPrice = 129;
	double sellingPrice = 191;
	double profit = sellingPrice-costPrice;
	double profitPercentage = ((profit/costPrice)*100);
	
	//print the cost Price and selling Price with its profit and profit percentage
	System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n"+" The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage );
	}
}