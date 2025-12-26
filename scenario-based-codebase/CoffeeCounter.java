//created class named CoffeeCounter
import java.util.Scanner;
public class CoffeeCounter{
    public static void main(String[]args){
		
		//take coffee type and quantity as input
        Scanner input=new Scanner(System.in);
        double gst = 0.05;
        while (true) {
            System.out.print("Enter coffee type or exit: ");
            String type=input.nextLine().toLowerCase();
            if(type.equals("exit")){
                break;
            }
            System.out.print("Enter quantity: ");
            int qty=input.nextInt();
            input.nextLine();
            int price;
            switch (type) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 150;
                    break;
                default:
                    System.out.println("Invalid coffee type");
                    continue;
            }
			
			//display the total bill
            double total = (price * qty);
			double bill = total + (total*gst);
            System.out.println("Total bill: " + bill);
            System.out.println();
        }      
    }
}