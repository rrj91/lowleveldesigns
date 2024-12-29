package com.scaler.repository;

import com.scaler.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Long,Ticket> ticketMap=new HashMap<>();

    public void save(Ticket ticket){
        ticketMap.put(ticket.getId(),ticket);
    }
}
