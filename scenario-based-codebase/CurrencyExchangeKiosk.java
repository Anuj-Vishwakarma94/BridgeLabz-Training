/*18. Currency Exchange Kiosk 💱
Design a currency converter:
● Take INR amount and target currency.
● Use a switch to apply the correct rate.
● Ask if the user wants another conversion (do-while).*/

//created class named CurrencyExchangeKiosk
import java.util.Scanner;
public class CurrencyExchangeKiosk {
    public static void main(String[] args) {

        final double USD_RATE = 0.012; 
        final double EUR_RATE = 0.011; 
        final double JPY_RATE = 1.77; 

        Scanner input = new Scanner(System.in);
        char choice;
        do {
			System.out.println("===== Currency Exchange Kiosk =====\n");
            System.out.print("Enter amount in INR: ");
            double inr = input.nextDouble();
            System.out.println("Choose target currency:");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            System.out.println("3. JPY");
            System.out.print("Enter option (1-3): ");
            int option = input.nextInt();
            double result = 0;
            switch (option) {
                case 1:
                    result = inr * USD_RATE;
                    System.out.println("INR " + inr + " = USD " + result);
                    break;

                case 2:
                    result = inr * EUR_RATE;
                    System.out.println("INR " + inr + " = EUR " + result);
                    break;

                case 3:
                    result = inr * JPY_RATE;
                    System.out.println("INR " + inr + " = JPY " + result);
                    break;

                default:
                    System.out.println("Invalid option selected!");
            }

            System.out.print("\nDo you want another conversion? (Y/N):
        }
	}
}	