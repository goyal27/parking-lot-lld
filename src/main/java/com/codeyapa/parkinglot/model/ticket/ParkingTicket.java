package com.codeyapa.parkinglot.model.ticket;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ParkingTicket {
    private final String id;
    private final LocalDateTime issuedAt;
    @Setter
    private LocalDateTime vacatedAt;
    private final String assignedVehicleId;
    private final String allocatedSpotId;
    private double charge;

    public void updateAmountCharged(double amountCharged) {
        this.charge = amountCharged;
    }
}
