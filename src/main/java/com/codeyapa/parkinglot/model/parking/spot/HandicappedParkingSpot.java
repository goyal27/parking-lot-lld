package com.codeyapa.parkinglot.model.parking.spot;

import lombok.Getter;

@Getter
public class HandicappedParkingSpot extends ParkingSpot {
    public HandicappedParkingSpot(String id) {
        super(id, ParkingSpotType.HANDICAPPED);
    }
}
