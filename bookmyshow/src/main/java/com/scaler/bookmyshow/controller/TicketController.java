package com.scaler.bookmyshow.controller;


import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.exceptions.SeatNotAvailableException;
import com.scaler.bookmyshow.exceptions.UserNotFoundException;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * This request happens when you select seat and move to payment page.
     * @param bookTicketRequest
     * @return bookTicketResponseDto containing ticketId,seats and audis
     */
    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequest) throws UserNotFoundException, InvalidArgumentException, SeatNotAvailableException {
        Ticket ticket = ticketService.bookTicket(bookTicketRequest.getSeatIds(),bookTicketRequest.getUserId(),bookTicketRequest.getShowId());
        return null;
    }
}
