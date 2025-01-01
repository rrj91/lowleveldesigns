package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private ShowSeatType seatType;
    @ManyToOne
    private Show show;
    private int price;
}
