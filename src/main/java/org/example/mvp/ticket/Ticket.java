package org.example.mvp.ticket;

public class Ticket {
    String registrationNumber;
    long startTime;

    public Ticket(String registrationNumber, long startTime) {
        this.registrationNumber = registrationNumber;
        this.startTime = startTime;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public long getStartTime() {
        return startTime;
    }
}
