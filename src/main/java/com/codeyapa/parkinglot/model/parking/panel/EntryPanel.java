package com.codeyapa.parkinglot.model.parking.panel;

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

    public ParkingTicket getTicket(Vehicle vehicle) {
        return null;
    }

    private ParkingTicket buildParkingTicket(Vehicle vehicle, String allocatedSpotId) {
        return ParkingTicket.builder()
                .id(UUID.randomUUID().toString())
                .issuedAt(LocalDateTime.now())
                .assignedVehicleId(vehicle.getLicenseNumber())
                .allocatedSpotId(allocatedSpotId)
                .build();
    }

}
