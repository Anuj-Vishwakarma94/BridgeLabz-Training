/*14. Movie Ticket Booking App 🎬
Ask users for movie type, seat type (gold/silver), and snacks.
● Use switch and if together.
● Loop through multiple customers.
● Clean structure and helpful variable names.*/

//created class named MovieTicketBookingApp
import java.util.Scanner;
public class MovieTicketBookingApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to our Movie Booking App");

        //used a while loop so loop run until user exit
        while (true) {

            System.out.println("Choose Movie (type exit to quit):");
            System.out.println("Inception\nInterstellar\nStrangers Things\nBahubali");

            String movie = input.nextLine().toLowerCase();
            if (movie.equals("exit")) break;

            System.out.println("Select Seat Type: Gold / Silver");
            String seat = input.nextLine().toLowerCase();

            System.out.println("Choose Snacks: Sandwiches / Popcorn / Burger");
            String snacks = input.nextLine().toLowerCase();
        //made 2 loops for movie and snacks
            switch (movie) {
                case "inception":
                case "interstellar":
                case "strangers things":
                case "bahubali":
                    System.out.println("Movie: " + movie);
                    break;
                default:
                    System.out.println("Invalid Movie");
                    continue;
            }

            if (seat.equals("gold") || seat.equals("silver")) {
                System.out.println("Seat: " + seat);
            } 
			else {
                System.out.println("Invalid Seat");
            }

            switch (snacks) {
                case "sandwiches":
                case "popcorn":
                case "burger":
                    System.out.println("Snacks: " + snacks);
                    break;
                default:
                    System.out.println("Invalid Snacks");
            }

            System.out.println();
        }
    }
}
