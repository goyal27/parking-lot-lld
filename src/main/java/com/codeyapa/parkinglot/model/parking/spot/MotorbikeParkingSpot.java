package com.codeyapa.parkinglot.model.parking.spot;

import lombok.Getter;

@Getter
public class MotorbikeParkingSpot extends ParkingSpot{
    public MotorbikeParkingSpot(String id) {
        super(id, ParkingSpotType.MOTORBIKE);
    }
}
