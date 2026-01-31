package com.smartcitymanagementsystem;

public class AmbulanceService implements TransportService, EmergencyService
{
	private String id;
    private int location;

    public AmbulanceService(String id, int location) 
    {
    	this.id = id;
        this.location = location;
    }
    
    @Override
    public String getServiceId() 
    {
    	return id; 
    }
    @Override 
    public String getType() 
    {
    	return "AMBULANCE"; 
    }
    @Override 
    public double getBaseRate() 
    {
    	return 0.0; 
    }
    @Override 
    public int getCurrentLocation() 
    {
    	return location; 
    }
    
    @Override
    public void printServiceDetails() 
    {
    	System.out.println("!!! EMERGENCY SERVICE [" + id + "] - PRIORITY ROUTE !!!");
    }
}
