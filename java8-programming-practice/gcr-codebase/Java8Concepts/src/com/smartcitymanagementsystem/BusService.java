package com.smartcitymanagementsystem;

public class BusService implements TransportService
{
	private String id;
    private int location;

    public BusService(String id, int location) 
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
    	return "BUS"; 
    }
    @Override 
    public double getBaseRate() 
    {
    	return 2.50;
    }
    @Override 
    public int getCurrentLocation() 
    {
    	return location; 
    }
}
