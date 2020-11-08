package com.codeyapa.parkinglot.model.parking.panel;

import com.codeyapa.parkinglot.model.parking.ParkingLot;
import com.codeyapa.parkinglot.model.pricing.PricingStrategy;
import com.codeyapa.parkinglot.model.ticket.ParkingTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ExitPanel {
    private final String id;
    private final PricingStrategy pricingStrategy;

    public void scanAndVacate(final ParkingTicket parkingTicket) {
        ParkingLot.INSTANCE.vacateParkingSpot(parkingTicket.getAllocatedSpotId());
        parkingTicket.setVacatedAt(LocalDateTime.now());
        parkingTicket.updateAmountCharged(pricingStrategy.calculateAmountCharged(parkingTicket));
    }
}
