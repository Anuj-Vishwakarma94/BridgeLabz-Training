package com.foreachmethod.emailnotifications;

import java.util.Arrays;
import java.util.List;

public class EmailNotificationsMain 
{
	public static void sendEmailNotification(String email) {
        // In a real application, this would connect to an SMTP server or API
        System.out.println("  Sending notification to: " + email + " ... [SENT]");
    }

	public static void main( String args[] )
	{
		List<String> emails = Arrays.asList(
	            "alice@example.com",
	            "bob.builder@construction.org",
	            "charlie.brown@peanuts.net",
	            "david.jones@techcorp.com",
	            "eve.hacker@securemail.com"
	        );
		
		System.out.println("#====# Starting Email Blast #====#");
		
		emails.forEach(email -> sendEmailNotification(email));
		
		System.out.println("#====# All Emails Sent #====#");
		
	}
	
	

}
