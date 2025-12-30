/*15. Rohan’s Library Reminder App 📚
Rohan wants a fine calculator:
● Input return date and due date.
● If returned late, calculate fine: ₹5/day.
● Repeat for 5 books using for-loop.*/

//created class named LibraryFineCalculator
import java.util.Scanner;
public class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
		//used a for loop to take as input the duedate and returndate
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter the Due Date & Return Date of the Books: ");
            int dueDate = input.nextInt();
            int returnDate = input.nextInt();
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;
                System.out.println("Book " + i + " Fine: ₹" + fine);
            } else {
                System.out.println("Book " + i + " Fine: ₹0");
            }
        }
    }
}
