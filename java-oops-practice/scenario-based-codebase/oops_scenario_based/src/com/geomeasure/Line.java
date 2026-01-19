package com.geomeasure;
public class Line {

    // encapsulated coordinates
    private double x1, y1, x2, y2;

    // constructor to initialize line
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // method to calculate length of line
    public double getLength() {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
    }
}
