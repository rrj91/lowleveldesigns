package com.scaler.bookmyshow.service;

import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.exceptions.SeatNotAvailableException;
import com.scaler.bookmyshow.exceptions.TicketNotFoundException;
import com.scaler.bookmyshow.exceptions.UserNotFoundException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(SeatRepository seatRepository, ShowSeatRepository showSeatRepository,ShowRepository showRepository,UserRepository userRepository,ShowSeatTypeRepository showSeatTypeRepository
    , TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository=showRepository;
        this.userRepository=userRepository;
        this.showSeatTypeRepository=showSeatTypeRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> seatIds, Long userId, Long showId) throws SeatNotAvailableException, InvalidArgumentException, UserNotFoundException {
        //1. get Show seats
        //2. check show seats status
        //2.a Every seat available
        //2.a.a lock every seat
        //2.a.b change the satus
        //2.a.c.Create ticket object and return
        //2.b some seats are available
        //2.b.a throw exception
        //getSeatsForIds(ids)
        //getShowsForSeats(seats)
        List<Seat> selectedSeats = seatRepository.findAllByIdIn(seatIds);
        Optional<Show> show = showRepository.findById(showId);
        if(show.isEmpty()){
            throw new InvalidArgumentException("Show by: "+showId+" doesn't exists");
        }
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(selectedSeats,show.get());
        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowStatus().equals(ShowStatus.EMPTY)){
                throw new SeatNotAvailableException("Seat Id: "+showSeat.getSeat().getNumber()+" is not available");
            }
        }
        for(ShowSeat showSeat: showSeats){
            showSeat.setShowStatus(ShowStatus.BLOCKED);
            showSeat.setBlockedTime(new Date());
        }
        showSeatRepository.saveAll(showSeats);
        Optional<User> user = this.userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User with Id: "+userId+" not found!");
        }
        int amount =0;
        for(ShowSeat showSeat: showSeats){
            ShowSeatType showSeatType = showSeatTypeRepository.findByShowAndSeatType(show.get(),showSeat.getSeat().getSeatType());
            amount += showSeatType.getPrice();
            //Need to implement Tax calculation strategy
        }
        Ticket ticket = new Ticket();
        ticket.setBookedBy(user.get());
        ticket.setShow(show.get());
        ticket.setSeats(selectedSeats);
        ticket.setAmount(amount);
        ticketRepository.save(ticket);
        return ticket;
    }

    Ticket cancelTicket(Long ticketId) throws TicketNotFoundException {
       Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
       if(ticketOpt.isEmpty()){
           throw new TicketNotFoundException("Ticket with id: "+ticketId+" not found!");
       }
       Ticket ticket= ticketOpt.get();
       List<Seat> seats = ticket.getSeats();
       List<ShowSeat> showSeats = new ArrayList<>();
       for(Seat seat: seats){
           Optional<ShowSeat> showSeat = showSeatRepository.findBySeatAndShow(seat,ticket.getShow());
           showSeat.get().setShowStatus(ShowStatus.EMPTY);
           showSeats.add(showSeat.get());
       }
       showSeatRepository.saveAll(showSeats);
       ticket.setStatus(TicketStatus.CANCELLED);
       return ticketRepository.save(ticket);
    }

    Ticket transferTicket(Long ticketId,Long toUserId,Long fromUserId) throws TicketNotFoundException, UserNotFoundException {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if(ticket.isEmpty()){
            throw new TicketNotFoundException("Ticket with Id: "+ticketId+" not found!");
        }
        Optional<User> toUserO = userRepository.findById(toUserId);
        Optional<User> fromUserO = userRepository.findById(fromUserId);
        if(toUserO.isEmpty() || fromUserO.isEmpty()){
            throw new UserNotFoundException("Users not found");
        }
        User toUser = toUserO.get();
        User fromUser = fromUserO.get();
        fromUser.getTickets().remove(ticket.get());
        userRepository.save(toUser);
        toUser.getTickets().add(ticket.get());
        userRepository.save(toUser);
        ticket.get().setBookedBy(toUser);
        return ticketRepository.save(ticket.get());


    }

}
