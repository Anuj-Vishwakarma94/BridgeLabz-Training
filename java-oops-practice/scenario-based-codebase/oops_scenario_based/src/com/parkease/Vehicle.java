package com.parkease;
public abstract class Vehicle implements IPayable {
    protected String vehicleNo;

    public Vehicle(String vehicleNo){
        this.vehicleNo = vehicleNo;
    }
}
