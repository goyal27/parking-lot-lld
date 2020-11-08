package com.codeyapa.parkinglot.model.parking.spot;

import com.codeyapa.parkinglot.model.vehichle.Vehicle;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public abstract class ParkingSpot {
    private final String id;
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
        this.assignedVehicle=vehicle;
    }
}
