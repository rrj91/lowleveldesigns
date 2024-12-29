package com.scaler.services;

import com.scaler.models.Vehicle;
import com.scaler.models.VehicleType;
import com.scaler.repository.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }
    public Vehicle registerVehicle(String number, VehicleType vehicleType){
        return this.vehicleRepository.createVehicleByVehicleNumber(number,vehicleType);
    }
    public Vehicle getVehicle(String number){
        return this.vehicleRepository.findVehicleByVehicleNumber(number);
    }
}
