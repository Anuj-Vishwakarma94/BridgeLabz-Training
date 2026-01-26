package com.parkease;

public class ParkingSlot {

    private String slotId;
    private boolean isOccupied;
    private String vehicleTypeAllowed;
    private String location;

    private String lastBookedVehicle = "None";

    public ParkingSlot(String slotId, String location, String vehicleTypeAllowed){
        this.slotId = slotId;
        this.location = location;
        this.vehicleTypeAllowed = vehicleTypeAllowed;
        this.isOccupied = false;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public boolean bookSlot(Vehicle v){
        if(isOccupied) return false;

        if(!v.getClass().getSimpleName().equalsIgnoreCase(vehicleTypeAllowed)){
            return false;
        }

        isOccupied = true;
        lastBookedVehicle = v.vehicleNo;
        return true;
    }

    public void freeSlot(){
        isOccupied = false;
    }

    public String getBookingLog(){
        return "Last booked vehicle: " + lastBookedVehicle;
    }

    public String getSlotId(){
        return slotId;
    }
}
