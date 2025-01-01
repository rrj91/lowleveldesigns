package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "chair")
public class Seat extends BaseModel{
    private String number;
    @Column(name = "rowz")
    private int row;
    @Column(name = "colz")
    private int col;
    @ManyToOne
    private SeatType seatType;
}
