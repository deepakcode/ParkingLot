package org.example.mvp.charge_streatgy;

import org.example.mvp.parkinglot.Slot;
import org.example.mvp.vehicle.Vehicle;

import java.util.List;

public interface ParkingStreatgy {
    Slot findSlot(List<Slot> slots);
}
