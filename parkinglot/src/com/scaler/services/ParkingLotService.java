package com.scaler.services;

import com.scaler.models.Gate;
import com.scaler.models.ParkingLot;
import com.scaler.models.ParkingSpot;
import com.scaler.models.VehicleType;
import com.scaler.repository.ParkingLotRepository;
import com.scaler.strategies.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLotService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public ParkingSpot getParkingSpot(VehicleType vehicleType, Gate gate){
        List<ParkingSpot> parkingSpots = parkingLotRepository.getParkingAllParkingSpot();
        return this.spotAssignmentStrategy.assignParkingSpot(vehicleType,gate,parkingSpots);
    }
}
