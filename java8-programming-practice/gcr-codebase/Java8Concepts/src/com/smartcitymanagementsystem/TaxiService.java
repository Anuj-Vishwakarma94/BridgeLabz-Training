package com.smartcitymanagementsystem;

public class TaxiService implements TransportService
{
	private String id;
    private int location;

    public TaxiService(String id, int location) 
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
    	return "TAXI"; 
    }
    @Override 
    public double getBaseRate() 
    {
    	return 5.00; 
    }
    @Override 
    public int getCurrentLocation() 
    {
    	return location; 
    }
    
}
