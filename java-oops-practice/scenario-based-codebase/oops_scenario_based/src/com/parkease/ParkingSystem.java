package com.parkease;
import java.util.*;

public class ParkingSystem {

    private List<ParkingSlot> slots = new ArrayList<>();

    public void addSlot(ParkingSlot slot){
        slots.add(slot);
    }

    public ParkingSlot assignSlot(Vehicle v){
        for(ParkingSlot slot : slots){
            if(slot.isAvailable() 
                && slot.bookSlot(v)){
                return slot;
            }
        }
        return null;
    }
}
