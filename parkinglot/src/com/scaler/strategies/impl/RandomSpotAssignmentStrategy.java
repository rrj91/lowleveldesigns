package com.scaler.strategies.impl;

import com.scaler.models.Gate;
import com.scaler.models.ParkingSpot;
import com.scaler.models.SpotStatus;
import com.scaler.models.VehicleType;
import com.scaler.strategies.SpotAssignmentStrategy;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate, List<ParkingSpot> parkingSpots) {
        for (ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getSpotStatus() == SpotStatus.VACANT && parkingSpot.getSupportedVehicleType().contains(vehicleType)){
                return parkingSpot;
            }
        }
        return null;
    }
}
