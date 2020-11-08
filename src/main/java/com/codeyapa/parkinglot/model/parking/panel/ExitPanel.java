package com.codeyapa.parkinglot.model.parking.panel;

import com.codeyapa.parkinglot.model.ticket.ParkingTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExitPanel {
    private final String id;

    public void processTicket(ParkingTicket parkingTicket){}
}
