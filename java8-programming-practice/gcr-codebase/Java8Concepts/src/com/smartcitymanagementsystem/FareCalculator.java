package com.smartcitymanagementsystem;

@FunctionalInterface
public interface FareCalculator 
{
	double calculateFare( double distance, double baseRate );

}
