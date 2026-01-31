package com.smartcitymanagementsystem;

public class Trip 
{
	private String routeName;
    private double farePaid;
    private boolean isPeakHour;

    public Trip(String routeName, double farePaid, boolean isPeakHour) 
    {
        this.routeName = routeName;
        this.farePaid = farePaid;
        this.isPeakHour = isPeakHour;
    }

    public String getRouteName() 
    {
    	return routeName; 
    }
    public double getFarePaid() 
    {
    	return farePaid; 
    }
    public boolean isPeakHour() 
    {
    	return isPeakHour; 
    }
    
    @Override
    public String toString() 
    {
    	return routeName + " ($" + farePaid + ")"; 
    }

}
