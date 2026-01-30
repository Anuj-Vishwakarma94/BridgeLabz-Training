package com.foreachmethod.iotsensorreading;

import java.util.Arrays;
import java.util.List;

public class SensorMain 
{
	public static void main( String args[] )
	{
		List<SensorReading> readings = Arrays.asList(
	            new SensorReading("S-101", 45.5),
	            new SensorReading("S-102", 82.0), // High
	            new SensorReading("S-103", 40.0),
	            new SensorReading("S-104", 91.5), // High
	            new SensorReading("S-105", 55.2)
	        );
		
		double threshold = 80.0;
        System.out.println("--- CRITICAL ALERTS (Threshold: " + threshold + "°C) ---");
        
        readings.stream()
        .filter(reading -> reading.getTemperature() > threshold)
        .forEach(reading -> 
        {
        	System.out.println("ALERT! " + reading);
        });
	}

}
