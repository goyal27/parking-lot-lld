package com.codeyapa.parkinglot.model.parking.spot;

import lombok.Getter;

@Getter
public class LargeParkingSpot extends ParkingSpot{
    public LargeParkingSpot(String id) {
        super(id, ParkingSpotType.LARGE);
    }
}
