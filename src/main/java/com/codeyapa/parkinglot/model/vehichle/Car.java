package com.codeyapa.parkinglot.model.vehichle;

public class Car extends Vehicle{
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
