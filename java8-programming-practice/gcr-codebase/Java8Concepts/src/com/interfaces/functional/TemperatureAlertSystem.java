package com.interfaces.functional;

import java.util.function.Predicate;

public class TemperatureAlertSystem {
	
    private static void checkTemperature(double temperature) {
        Predicate<Double> isHighTemp = temp -> temp > 37.5;
        
        if (isHighTemp.test(temperature)) System.out.println("ALERT: Temperature is above safe limit!\n");
        else System.out.println("Temperature is Normal\n");
    }
    
    public static void main(String[] args) {
        checkTemperature(38.2);
        checkTemperature(32.5);
        checkTemperature(39.7);
    }
}

