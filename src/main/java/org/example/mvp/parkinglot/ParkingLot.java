package org.example.mvp.parkinglot;

import org.example.mvp.ParkingMediator;
import org.example.mvp.charge_streatgy.NearestAvailableFirst;
import org.example.mvp.charge_streatgy.ParkingStreatgy;
import org.example.mvp.ticket.Ticket;
import org.example.mvp.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    ParkingStreatgy parkingStreatgy;
    public static int noOfParkingSlots = 100;
    List<Slot> slotList;
    ParkingMediator parkingMediator;

    public ParkingLot(NearestAvailableFirst nearestAvaialableFirst) {
        parkingStreatgy = nearestAvaialableFirst;
        slotList = new ArrayList<>(noOfParkingSlots);
        for(int i=0; i<noOfParkingSlots; i++){
            slotList.add(new Slot(i,1));
        }
        parkingMediator = new ParkingMediator();
    }

    public Slot park(Vehicle vehicle) {
        Slot slot = parkingStreatgy.findSlot(slotList);
        slot.setOccupied(true);
        slot.setOccupiedSince(System.currentTimeMillis());
        parkingMediator.createAssociation(slot,vehicle); // faster lookup & temp association
        return slot;
    }

    public Slot unPark(Ticket ticket) {
        Slot slot =  parkingMediator.getParkedSlot(ticket.getRegistrationNumber());
        slot.setOccupied(false);
        return slot;
    }
}
