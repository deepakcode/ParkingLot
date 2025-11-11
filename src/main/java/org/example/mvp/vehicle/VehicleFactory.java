package org.example.mvp.vehicle;

public class VehicleFactory {

    public static Vehicle getVehicle(VehicleType vehicleType, String registrationNumber) throws IllegalAccessException {
        if (vehicleType == VehicleType.CAR) {
            return new Car(registrationNumber);
        } else if (vehicleType == VehicleType.TRUCK) {
            return new Truck(registrationNumber);
        } else {
            throw new IllegalAccessException("Unknown vehicle type: " + vehicleType);
        }
    }
}
