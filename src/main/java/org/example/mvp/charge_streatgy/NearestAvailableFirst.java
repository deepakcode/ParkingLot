package org.example.mvp.charge_streatgy;

import org.example.mvp.parkinglot.Slot;
import org.example.mvp.vehicle.Vehicle;

import java.util.List;

public class NearestAvailableFirst implements ParkingStreatgy {

    @Override
    public Slot findSlot(List<Slot> slots) {
        return slots.stream()
                .filter(s -> !s.isOccupied())
                .findFirst()
                .orElse(null);
    }
}
