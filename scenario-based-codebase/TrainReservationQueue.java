/*12. Train Reservation Queue 🚆
Simulate a basic ticket booking system.
● Show menu with switch
● Allow multiple bookings using while-loop.
● Stop booking once seats reach zero (break).*/

//created class named TrainReservationQueue
import java.util.Scanner;
    public class  TrainReservationQueue {
    public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.println("Welcome to Ticket Booking Portal!");
	System.out.println("Enter the City you wanna travel: " + "\n Delhi" + "\n Mumbai" + "\n Banglore" + "Gangtok");
	int seats = 3;
	     
		  //display the status of ticket booking 
	      while(seats >0){ 
			String ticket = input.nextLine().toLowerCase();
			switch (ticket) {
			case "delhi" :
		        System.out.println("You have Successfully booked Ticket for Delhi");
				seats--;
		        break;
			case "mumbai" :
		        System.out.println("You have Successfully booked Ticket for Mumbai");
			    seats--;
				break;
			case "banglore" :
		        System.out.println("You have Successfully booked Ticket for Banglore");
				seats--;
				break;
			case "gangtok" :
		        System.out.println("You have Successfully booked Ticket for Gangtok");
				seats--;
				break;
		    default :
		       System.out.println("Invalid Input");	
			}
		}
		if(seats <= 0){
			System.out.println("Sorry,No more Seats");
		}
		else{
			System.out.println("Thanks for Booking");
		}
	}
}