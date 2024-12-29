package com.scaler.services;

import com.scaler.models.*;
import com.scaler.repository.TicketRepository;
import com.scaler.strategies.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSpotService parkingSpotService;
    private TicketRepository ticketRepository;


    private ParkingLotService parkingLotService;

    public TicketService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) {
        /*
        1. Get vehicle by number
        2. If not, create and add it
        3. Assign parking spot
        4. update the parking spot status as occupied
        5. Generate ticket
         */
        Vehicle vehicle = this.vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null){
            vehicle = this.vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }
        Gate gate = gateService.getGate(gateId);
        //TODO assign the spot
        ParkingSpot parkingSpot = parkingLotService.getParkingSpot(vehicleType,gate);
         parkingSpotService.updateParkingSpot(parkingSpot);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setParkingSpot(parkingSpot);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());
        ticketRepository.save(ticket);

       return ticket;
    }



}
