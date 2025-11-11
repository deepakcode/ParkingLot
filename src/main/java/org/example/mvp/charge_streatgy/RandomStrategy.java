package org.example.mvp.charge_streatgy;

import org.example.mvp.parkinglot.Slot;
import org.example.mvp.vehicle.Vehicle;

import java.util.List;
import java.util.Random;

public class RandomStrategy implements ParkingStreatgy {

    @Override
    public Slot findSlot(List<Slot> slots) {
        Random random = new Random();
        List<Slot> availableSlot =  slots.stream()
                .filter(s -> !s.isOccupied())
                .toList();
        if(!availableSlot.isEmpty()){
            return availableSlot.get(random.nextInt(availableSlot.size()));
        }
        return null;
    }
}
