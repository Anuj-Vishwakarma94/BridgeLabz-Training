/*19. Bus Route Distance Tracker 🚌
Each stop adds distance.
● Ask if the passenger wants to get off at a stop.
● Use a while-loop with a total distance tracker.
● Exit on user confirmation.*/

//created class named BusRouteDistanceTracker
import java.util.Scanner;
public class BusRouteDistanceTracker{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double totalDistance = 0.0;  
        double stopDistance;         
        char choice;      
        
        System.out.println("Bus Route Distance Tracker");

        while (true) {

            // ask distance from previous stop to current
            System.out.print("Enter distance to next stop (in km): ");
            stopDistance = input.nextDouble();

            totalDistance += stopDistance;

            // ask if passenger wants to get off
            System.out.print("Do you want to get off at this stop? (y/n): ");
            choice = input.next().charAt(0);

            if (choice == 'y' || choice == 'Y') {
                break; 
            }
        }

        System.out.println("\nYou travelled a total distance of: " + totalDistance + " km");
    }
}
