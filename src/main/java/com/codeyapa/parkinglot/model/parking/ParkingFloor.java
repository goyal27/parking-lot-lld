package com.codeyapa.parkinglot.model.parking;

import com.codeyapa.parkinglot.exception.InvalidParkingFloorException;
import com.codeyapa.parkinglot.model.parking.spot.ParkingSpot;
import com.codeyapa.parkinglot.model.parking.spot.ParkingSpotType;
import com.codeyapa.parkinglot.model.vehichle.Vehicle;
import com.codeyapa.parkinglot.model.vehichle.VehicleType;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ParkingFloor {
    @Getter
    private final String id;
    private final Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots;
    private final Map<String, ParkingSpot> usedParkingSpots;

    public ParkingFloor(String id) {
        this.id = id;
        parkingSpots = new HashMap<>();
        usedParkingSpots = new HashMap<>();
        parkingSpots.put(ParkingSpotType.HANDICAPPED, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.CAR, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.MOTORBIKE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.ELECTRIC_CAR, new ConcurrentLinkedDeque<>());
    }

    public void addParkingSpot(final ParkingSpot parkingSpot) {
        Optional<ParkingSpot> spot = parkingSpots.get(parkingSpot.getParkingSpotType())
                .stream()
                .filter(pS -> pS.getId().equals(parkingSpot.getId()))
                .findAny();
        if (spot.isPresent())
            return;
        parkingSpots.get(parkingSpot.getParkingSpotType()).add(parkingSpot);
    }

    public synchronized ParkingSpot getParkingSpot(final Vehicle vehicle) throws InvalidParkingFloorException {
        ParkingSpotType parkingSpotType = getParkingSpotTypeForVehicle(vehicle.getVehicleType());
        if (!canPark(parkingSpotType))
            throw new InvalidParkingFloorException("Cannot Find a spot");
        ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();
        parkingSpot.assignVehicle(vehicle);
        usedParkingSpots.put(parkingSpot.getId(), parkingSpot);
        return parkingSpot;
    }

    public void vacateParkingSpot(final String parkingSpotId) {
        ParkingSpot parkingSpot = usedParkingSpots.get(parkingSpotId);
        if (Objects.nonNull(parkingSpot)) {
            parkingSpot.vacateSpot();
            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
        }
    }

    private boolean canPark(final ParkingSpotType parkingSpotTypeForVehicle) {
        return parkingSpots.get(parkingSpotTypeForVehicle).size() > 0;
    }

    private ParkingSpotType getParkingSpotTypeForVehicle(final VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return ParkingSpotType.CAR;
            case ELECTRIC:
                return ParkingSpotType.ELECTRIC_CAR;
            case MOTORBIKE:
                return ParkingSpotType.MOTORBIKE;
            default:
                return ParkingSpotType.LARGE;
        }
    }
}
