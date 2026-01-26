package com.constructors.level1;
import java.util.Scanner;
public class LibraryBookingSystem {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the books (Atomic Life,Freedom to Live,The Art of Living): ");
		String name = input.nextLine();
		Book b = new Book();
		boolean bookAvail = b.isAvailable(name);
		if( bookAvail) {
			System.out.print(name + " is available");
		}
		else {
			System.out.println(name + " isn't available");
		}
		input.close();
	}
}