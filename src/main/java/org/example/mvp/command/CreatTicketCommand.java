package org.example.mvp.command;

import org.example.mvp.parkinglot.Slot;
import org.example.mvp.ticket.Ticket;
import org.example.mvp.ticket.TicketService;
import org.example.mvp.vehicle.Vehicle;

public class CreatTicketCommand implements Command <Ticket>{
    public TicketService ticketService;
    public Slot slot;
    public Vehicle vehicle;

    public CreatTicketCommand(TicketService ticketService, Slot slot, Vehicle vehicle) {
        this.ticketService = ticketService;
        this.slot = slot;
        this.vehicle = vehicle;
    }

    @Override
    public Ticket execute() {
       return ticketService.createTicket(slot, vehicle);
    }
}
