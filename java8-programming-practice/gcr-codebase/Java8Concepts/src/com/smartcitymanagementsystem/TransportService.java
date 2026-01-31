package com.smartcitymanagementsystem;

public interface TransportService 
{
	String getServiceId();
	String getType();
	double getBaseRate();
	int getCurrentLocation();
	
	default void printServiceDetails()
	{
		System.out.println("Service [" + getType() + "] ID: " + getServiceId()
		 + " | Base Rate: $" + getBaseRate());
	}

}
