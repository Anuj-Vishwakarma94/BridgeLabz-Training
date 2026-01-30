package com.foreachmethod.eventattendeewelcomemessage;

import java.util.Arrays;
import java.util.List;

public class WelcomeMain 
{
	public static void main( String args[] )
	{
		List<Attendee> attendees = Arrays.asList(
	            new Attendee("John Smith", "VIP"),
	            new Attendee("Sarah Connor", "Standard"),
	            new Attendee("Kyle Reese", "Speaker"),
	            new Attendee("Marcus Wright", "Standard"),
	            new Attendee("T-800", "VIP")
	        );
		
		System.out.println("--- Sending Welcome Messages ---");
		
		attendees.stream().forEach(attendee -> {
			String badgeColor = "WHITE";
			if ("VIP".equals((attendee.getTicketType()))) {
				badgeColor = "GOLD";
			} else if ("Speaker".equals((attendee.getTicketType()))) {
				badgeColor = "BLUE";
			}
			System.out.println("Hello " + (attendee.getName() + 
					"! Your access level is [" + (attendee.getTicketType() + 
					"]. Please pick up your " + badgeColor + " badge.")));
			});
	}

}
