package com.codeyapa.parkinglot.model.pricing;

import com.codeyapa.parkinglot.model.ticket.ParkingTicket;

public interface PricingStrategy {
    double calculateAmountCharged(ParkingTicket parkingTicket);
}
