package com.scaler.repository;

import com.scaler.models.Vehicle;
import com.scaler.models.VehicleType;

import java.util.HashMap;

public class VehicleRepository {
    HashMap<String, Vehicle> vehicleHashMap = new HashMap<>();
    public Vehicle findVehicleByVehicleNumber(String vehicleNumber){
        if(vehicleHashMap.containsKey(vehicleNumber)){
            return vehicleHashMap.get(vehicleNumber);
        }
        return null;
    }

    public Vehicle createVehicleByVehicleNumber(String vehicleNumber, VehicleType vehicleType){
        if(!vehicleHashMap.containsKey(vehicleNumber)){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicleHashMap.put(vehicleNumber,vehicle);
        }
        return vehicleHashMap.get(vehicleNumber);
    }
}
