package com.codeyapa.parkinglot.model.parking;

import com.codeyapa.parkinglot.exception.InvalidParkingFloorException;
import com.codeyapa.parkinglot.model.account.common.Address;
import com.codeyapa.parkinglot.model.parking.panel.EntryPanel;
import com.codeyapa.parkinglot.model.parking.panel.ExitPanel;
import com.codeyapa.parkinglot.model.parking.spot.ParkingSpot;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
public class ParkingLot {
    private final String id;
    private Address address;
    private final List<ParkingFloor> parkingFloors;
    private final List<EntryPanel> entryPanels;
    private final List<ExitPanel> exitPanels;

    public static final ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot() {
        this.id = UUID.randomUUID().toString();
        this.parkingFloors = new ArrayList<>();
        this.entryPanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
    }

    public void updateAddress(Address address) {
        this.address = address;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        Optional<ParkingFloor> floor = parkingFloors.stream()
                .filter(pF -> pF.getId().equals(parkingFloor.getId()))
                .findFirst();
        if (floor.isPresent())
            return;
        parkingFloors.add(parkingFloor);
    }

    public void addEntryPanel(EntryPanel entryPanel) {
        Optional<EntryPanel> panel = entryPanels.stream()
                .filter(eP -> eP.getId().equals(entryPanel.getId()))
                .findFirst();
        if (panel.isPresent())
            return;
        entryPanels.add(entryPanel);
    }

    public void addExitPanel(ExitPanel exitPanel) {
        Optional<ExitPanel> panel = exitPanels.stream()
                .filter(eP -> eP.getId().equals(exitPanel.getId()))
                .findFirst();
        if (panel.isPresent())
            return;
        exitPanels.add(exitPanel);
    }

    public void addParkingSpot(String floorId, ParkingSpot parkingSpot) throws InvalidParkingFloorException {
        Optional<ParkingFloor> parkingFloor = parkingFloors.stream()
                .filter(pF -> pF.getId().equals(floorId))
                .findFirst();
        if (!parkingFloor.isPresent())
            throw new InvalidParkingFloorException("Parking Floor with id " +  floorId + " doesn't exists");
        parkingFloor.get().addParkingSpot(parkingSpot);
    }
}
