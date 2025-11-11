package org.example.mvp;

import org.example.mvp.parkinglot.Slot;
import org.example.mvp.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingMediator {
    private Map<String, Slot> vehicleSlotMap; // cen

    public ParkingMediator(){
        vehicleSlotMap = new HashMap<>();
    }

    public Slot createAssociation(Slot slot, Vehicle vehicle) {
        vehicleSlotMap.put(vehicle.getRegistrationNumber(), slot);
        return slot;
    }

    public Slot getParkedSlot(String registrationNumber) {
       return  vehicleSlotMap.remove(registrationNumber);
    }

}
