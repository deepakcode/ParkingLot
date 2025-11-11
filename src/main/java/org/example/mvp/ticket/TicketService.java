package org.example.mvp.ticket;

import org.example.mvp.parkinglot.Slot;
import org.example.mvp.vehicle.Vehicle;

public class TicketService {
    public Ticket createTicket(Slot slot, Vehicle vehicle) {
        long startTime = slot.getOccupiedSince();
        return new Ticket(vehicle.getRegistrationNumber(), startTime);
    }

    public Double getParkingCharge(Ticket ticket){
        int parkingRate = 30;
        long endTime  = System.currentTimeMillis();
        long hours = ((endTime - ticket.getStartTime())/1000)*60*60;
        System.out.println("parking hours: "+hours);
        return (double) (hours * parkingRate);
    }
}
