package org.example.mvp.parkinglot;

public class Slot {
    private final int id;
    private final int level;
    private boolean occupied;
    private long occupiedSince;

    public Slot(int id, int level) {
        this.id = id;
        this.level = level;
        this.occupied = false;
    }

    public void setOccupiedSince(long occupiedSince) {
        this.occupiedSince = occupiedSince;
    }

    public long getOccupiedSince() {
        return occupiedSince;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void vacate() {
        occupied = false;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Slot{id=" + id + ", level=" + level + ", occupied=" + occupied + "}";
    }
}

