package org.example.mvp.command;

import org.example.mvp.parkinglot.ParkingLot;
import org.example.mvp.parkinglot.Slot;
import org.example.mvp.vehicle.Vehicle;

public class ParkCommand implements Command<Slot>{

    public ParkingLot parkingLot;
    public Vehicle vehicle;

    public ParkCommand(ParkingLot parkingLot, Vehicle vehicle) {
        this.parkingLot = parkingLot;
        this.vehicle = vehicle;
    }

    @Override
    public Slot execute() {
        return parkingLot.park(vehicle);
    }
}
