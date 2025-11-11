package org.example.mvp.command;

import org.example.mvp.parkinglot.ParkingLot;
import org.example.mvp.parkinglot.Slot;
import org.example.mvp.ticket.Ticket;
import org.example.mvp.vehicle.Vehicle;

public class UnParkCommand implements Command<Slot>{

    public ParkingLot parkingLot;
    public Ticket ticket;

    public UnParkCommand(ParkingLot parkingLot,Ticket ticket) {
        this.parkingLot = parkingLot;
        this.ticket = ticket;
    }

    @Override
    public Slot execute() {
        return parkingLot.unPark(ticket);
    }
}
