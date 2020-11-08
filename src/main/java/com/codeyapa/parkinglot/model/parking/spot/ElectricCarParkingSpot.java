package com.codeyapa.parkinglot.model.parking.spot;

import lombok.Getter;

@Getter
public class ElectricCarParkingSpot extends ParkingSpot{
    public ElectricCarParkingSpot(String id) {
        super(id, ParkingSpotType.ELECTRIC_CAR);
    }
}
