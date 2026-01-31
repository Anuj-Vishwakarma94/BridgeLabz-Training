package com.interfaces.staticmethods.unticonversiontool;

public interface UnitConverter {

    public static double kmToMiles(double km) {
        return km * 0.621371;
    }
   
    public static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}
