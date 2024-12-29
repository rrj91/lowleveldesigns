package com.scaler.strategies;

import com.scaler.models.Gate;
import com.scaler.models.ParkingSpot;
import com.scaler.models.VehicleType;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot assignParkingSpot(VehicleType vehicleType, Gate gate, List<ParkingSpot> parkingSpots);
}
