/*20. Festival Lucky Draw 🎉
At Diwali mela, each visitor draws a number.
● If the number is divisible by 3 and 5, they win a gift.
● Use if, modulus, and loop for multiple visitors.
● continue if input is invalid.*/

//created class named FestivalLuckyDraw
import java.util.Scanner;
public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of visitors: ");
        int visitors = input.nextInt();
        for (int i = 1; i <= visitors; i++) {
            System.out.print("Visitor " + i + " — Enter your lucky number: ");
            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Skipping this visitor...\n");
                input.next();  
                continue;       
            }
            int number = input.nextInt();
			
            // Check lucky condition
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Congratulations! You win a gift!\n");
            } else {
                System.out.println("Sorry, better luck next time.\n");
            }
        }
        System.out.println("Lucky Draw Finished. Thank you for participating!");
    }
}