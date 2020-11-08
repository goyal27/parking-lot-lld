package com.codeyapa.parkinglot.model.parking.spot;

import com.codeyapa.parkinglot.model.vehichle.Vehicle;
import lombok.Builder;
import lombok.Getter;

@Builder
public abstract class ParkingSpot {
    @Getter
    private final String id;
    @Getter
    private final ParkingSpotType parkingSpotType;
    private boolean isFree;
    private Vehicle assignedVehicle;

    public ParkingSpot(String id, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
        this.isFree = true;
    }

    public void assignVehicle(Vehicle vehicle) {
        isFree = false;
        assignedVehicle = vehicle;
    }

    public void vacateSpot() {
        isFree = false;
        assignedVehicle = null;
    }
}
