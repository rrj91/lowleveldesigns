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

    public ShowSeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(ShowSeatType seatType) {
        this.seatType = seatType;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
