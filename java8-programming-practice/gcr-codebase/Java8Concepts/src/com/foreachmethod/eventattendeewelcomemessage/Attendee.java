package com.foreachmethod.eventattendeewelcomemessage;

public class Attendee 
{
	private String name;
	private String ticketType;
	
	public Attendee ( String name, String ticketType )
	{
		this.name = name;
		this.ticketType = ticketType;
	}
	
	public String getName()
	{
		return name;
	}
	public String getTicketType()
	{
		return ticketType;
	}
	
}

