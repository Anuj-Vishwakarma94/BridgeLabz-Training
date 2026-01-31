package com.streamapi.hospitaldoctoravailability;

import java.util.List;

public class Doctor 
{
	private String name;
	private String specialty;
	private List<String> availableDays;
	
	public Doctor ( String name, String specialty, List<String> availableDays )
	{
		this.name = name;
		this.specialty = specialty;
		this.availableDays = availableDays;
	}
	
	public String getName()
	{
		return name;
	}
	public String getSpecialty()
	{
		return specialty;
	}
	public List<String> getAvailableDays()
	{
		return availableDays;
	}
	
	@Override 
	public String toString()
	{
		return "Dr. " + name + " (" + specialty + ") - Available: " + availableDays;
	}
}
