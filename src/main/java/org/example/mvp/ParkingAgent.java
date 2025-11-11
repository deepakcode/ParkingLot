package org.example.mvp;


import org.example.mvp.charge_streatgy.NearestAvailableFirst;
import org.example.mvp.parkinglot.ParkingLot;
import org.example.mvp.parkinglot.Slot;
import org.example.mvp.ticket.Ticket;
import org.example.mvp.ticket.TicketService;
import org.example.mvp.vehicle.Vehicle;
import org.example.mvp.vehicle.VehicleFactory;
import org.example.mvp.vehicle.VehicleType;

public class ParkingAgent {

    public static void main(String[] args) {

        String registrationNumber = "KA-01-NM-2345";
        Vehicle vehicle = null;
        try {
            vehicle = VehicleFactory.getVehicle(VehicleType.CAR, registrationNumber);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        ParkingLot parkingLot = new ParkingLot(new NearestAvailableFirst());

        // Does slot available?
        Slot slot = parkingLot.park(vehicle);

        TicketService ticketService = new TicketService();
        Ticket ticket = null;
        if (slot != null) {
            ticket = ticketService.createTicket(slot, vehicle);
        } else {
            System.out.println("There is no available slot to park");
        }
        //Does ticket has car info?
        Slot availableSlot = parkingLot.unPark(ticket);

        Double amount = ticketService.getParkingCharge(ticket);
        System.out.println("For vehicle "+vehicle.getRegistrationNumber()+" amount is "+amount);


    }
}
