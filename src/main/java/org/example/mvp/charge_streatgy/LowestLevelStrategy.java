package org.example.mvp.charge_streatgy;

import org.example.mvp.parkinglot.Slot;
import java.util.Comparator;
import java.util.List;

public class LowestLevelStrategy implements ParkingStreatgy {

    @Override
    public Slot findSlot(List<Slot> slots) {
        return slots.stream()
                .filter(s -> !s.isOccupied())
                .min(Comparator.comparing(Slot::getLevel))
                .orElse(null);
    }
}
