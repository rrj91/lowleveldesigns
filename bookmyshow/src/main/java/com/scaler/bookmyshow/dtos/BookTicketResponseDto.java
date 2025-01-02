package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private List<String> seatNumbers;
    private Long ticketId;
    private int amount;
    private String auditoriumName;
}
