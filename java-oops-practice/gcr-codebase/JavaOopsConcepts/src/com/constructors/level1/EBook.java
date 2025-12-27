package com.constructors.level1;

public class EBook extends Books{
	private double fileSize;
	public EBook(String ISBN, String title, String author, double fileSize) {
	super(ISBN, title, author);
	this.fileSize = fileSize;
	}

	public void displayEBookDetails() {
		System.out.println("ISBN: " + ISBN);
	    System.out.println("Title: " + title);
	    System.out.println("Author: " + getAuthor());
	    System.out.println("File Size: " + fileSize + " MB");
	}

	public static void main(String[] args) {
	    EBook eb = new EBook("9876543", "Java Concepts", "John BridgeStone", 2.5);
	    eb.displayEBookDetails();
	    eb.setAuthor("Dr. BridgeStone");
	    eb.displayEBookDetails();
	}	
}
