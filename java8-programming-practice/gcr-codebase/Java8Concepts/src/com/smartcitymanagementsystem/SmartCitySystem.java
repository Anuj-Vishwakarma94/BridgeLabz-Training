package com.smartcitymanagementsystem;

import java.util.*;
import java.util.stream.Collectors;

public class SmartCitySystem 
{
	public static void main( String args[] )
	{
		List<TransportService> cityServices = Arrays.asList(
	            new BusService("B-101", 10),
	            new BusService("B-102", 50),
	            new TaxiService("T-505", 12),
	            new TaxiService("T-509", 80),
	            new AmbulanceService("AMB-911", 15)
	        );
		
		FareCalculator standardCalculator = (dist, rate) -> dist * rate;
		
		System.out.println("--- 1. Trip Booking Simulation (Lambdas) ---");
        int userLocation = 10;
        int destLocation = 30;
        
        double distance = GeoUtils.calculateDistance(userLocation, destLocation);
        
        cityServices.stream()
            .filter(s -> "TAXI".equals(s.getType())) 
            .map(s -> "Taxi " + s.getServiceId() + " Estimate: $" + 
                      standardCalculator.calculateFare(distance, s.getBaseRate()))
            .forEach(System.out::println);

        System.out.println("\n--- 2. Traffic Control (Marker Interface) ---");
        for (TransportService service : cityServices) 
        {
            if (service instanceof EmergencyService) 
            {
                System.out.println("ALERT: Clearing traffic for " + service.getServiceId());
                service.printServiceDetails();
            }
        }

        System.out.println("\n--- 3. Live Dashboard (Default Methods) ---");
        cityServices.forEach(TransportService::printServiceDetails);

        List<Trip> history = Arrays.asList(
            new Trip("Route-A", 12.5, true),
            new Trip("Route-B", 8.0, false),
            new Trip("Route-A", 15.0, true),
            new Trip("Route-C", 22.0, true),
            new Trip("Route-B", 7.5, false)
        );

        System.out.println("\n--- 4. Analytics Report (Collectors) ---");

        Map<String, List<Trip>> tripsByRoute = history.stream()
            .collect(Collectors.groupingBy(Trip::getRouteName));
        
        System.out.println("Trips per Route: " + tripsByRoute.keySet());

        Map<Boolean, List<Trip>> peakAnalysis = history.stream()
            .collect(Collectors.partitioningBy(Trip::isPeakHour));
        
        System.out.println("Peak Hour Trips Count: " + peakAnalysis.get(true).size());
        System.out.println("Off-Peak Trips Count: " + peakAnalysis.get(false).size());

        DoubleSummaryStatistics revenueStats = history.stream()
            .collect(Collectors.summarizingDouble(Trip::getFarePaid));
        
        System.out.println("Total Revenue: $" + revenueStats.getSum());
        System.out.println("Average Fare: $" + revenueStats.getAverage());
	}
}
