package com.scaler.controllers;

import com.scaler.dtos.GenerateTicketRequestDto;
import com.scaler.dtos.GenerateTicketResponseDto;
import com.scaler.dtos.ResponseStatus;
import com.scaler.exception.NoParkingSpotFoundException;
import com.scaler.models.Ticket;
import com.scaler.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public GenerateTicketResponseDto createTicket(GenerateTicketRequestDto generateTicketRequestDto){
        try {
            Ticket ticket = ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(), generateTicketRequestDto.getVehicleType(), generateTicketRequestDto.getGateId());
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return generateTicketResponseDto;
        }catch (NoParkingSpotFoundException e){
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setFailureMessage("No Parking spot found");
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateTicketResponseDto;
        }catch (Exception ex) {
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setFailureMessage("Some exception: "+ ex.getMessage());
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateTicketResponseDto;
        }

    }
}
