package com.constructors.level1;

public class HotelBooking {
	private String guestName;
	private String roomType;
	private int nights;
	
	// Default Constructor
	public HotelBooking() {
	this.guestName = "Harry";
	this.roomType = "Standard";
	this.nights = 1;
	}
	
	// Parameterized Constructor
	public HotelBooking(String guestName, String roomType, int nights) {
		this.guestName = guestName;
	    this.roomType = roomType;
	    this.nights = nights;
	}
	
	// Copy Constructor
	public HotelBooking(HotelBooking other) {
	this.guestName = other.guestName;
	this.roomType = other.roomType;
	this.nights = other.nights;
	}
	
	public String toString() {
		return "HotelBooking{" +"guestName=" + guestName  +", roomType = " + roomType + ", nights = " + nights +"}";
	    }
	    public static void main(String[] args) {

	        HotelBooking defaultBooking = new HotelBooking();
	        HotelBooking customBooking = new HotelBooking("Henry", "Deluxe", 3);
	        HotelBooking copiedBooking = new HotelBooking(customBooking);  

	        System.out.println(defaultBooking);
	        System.out.println(customBooking);
	        System.out.println(copiedBooking);
	    }
}