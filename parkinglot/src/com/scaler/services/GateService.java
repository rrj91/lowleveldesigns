package com.scaler.services;

import com.scaler.models.Gate;
import com.scaler.repository.GateRepository;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGate(Long gateId){

    }
}
