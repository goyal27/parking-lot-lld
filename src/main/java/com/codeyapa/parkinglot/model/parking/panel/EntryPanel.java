package com.codeyapa.parkinglot.model.parking.panel;

import com.codeyapa.parkinglot.exception.InvalidParkingFloorException;
import com.codeyapa.parkinglot.exception.ParkingFullException;
import com.codeyapa.parkinglot.model.parking.ParkingLot;
import com.codeyapa.parkinglot.model.parking.spot.ParkingSpot;
import com.codeyapa.parkinglot.model.ticket.ParkingTicket;
import com.codeyapa.parkinglot.model.vehichle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class EntryPanel {
    private final String id;

    public ParkingTicket getTicket(final Vehicle vehicle) throws ParkingFullException, InvalidParkingFloorException {
        final ParkingSpot parkingSpot = ParkingLot.INSTANCE.getParkingSpot(vehicle);
        return buildParkingTicket(vehicle.getLicenseNumber(), parkingSpot.getId());
    }

    private ParkingTicket buildParkingTicket(String licenseNumber, String allocatedSpotId) {
        return ParkingTicket.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(LocalDateTime.now())
                .assignedVehicleId(licenseNumber)
                .allocatedSpotId(allocatedSpotId)
                .build();
    }

}
