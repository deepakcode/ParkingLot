package org.example.mvp;


import org.example.mvp.charge_streatgy.NearestAvailableFirst;
import org.example.mvp.command.CommandInvoker;
import org.example.mvp.command.CreatTicketCommand;
import org.example.mvp.command.ParkCommand;
import org.example.mvp.parkinglot.ParkingLot;
import org.example.mvp.parkinglot.Slot;
import org.example.mvp.ticket.Ticket;
import org.example.mvp.ticket.TicketService;
import org.example.mvp.vehicle.Vehicle;
import org.example.mvp.vehicle.VehicleFactory;
import org.example.mvp.vehicle.VehicleType;

public class ParkingAgent {

    public static void main(String[] args) {

        TicketService ticketService = new TicketService();
        String registrationNumber = "KA-01-NM-2345";
        Vehicle vehicle = null;
        try {
            vehicle = VehicleFactory.getVehicle(VehicleType.CAR, registrationNumber);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        CommandInvoker<Slot> parkCommandInvoker = new CommandInvoker<>();
        Slot slot = parkCommandInvoker.invoke(new ParkCommand(new ParkingLot(new NearestAvailableFirst()), vehicle));

        CommandInvoker<Ticket> ticketCommandInvoker = new CommandInvoker<>();
        Ticket ticket = ticketCommandInvoker.invoke(new CreatTicketCommand(ticketService, slot, vehicle));

        if (ticket != null) {
            System.out.println("Ticket created successfully: " + ticket.getTicketId());
        } else {
            System.out.println("Failed to create ticket.");
        }
    }
}
