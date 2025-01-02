package com.scaler.bookmyshow.repository;

import com.scaler.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Override
    Ticket save(Ticket ticket);
}
