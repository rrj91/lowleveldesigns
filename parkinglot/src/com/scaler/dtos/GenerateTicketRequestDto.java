package com.scaler.dtos;

import com.scaler.models.VehicleType;

public class GenerateTicketRequestDto {
    private Long gateId;
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateIds) {
        this.gateId = gateIds;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
