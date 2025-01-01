package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Auditorium extends BaseModel{
    private String number;
    private List<Seat> seats;
    private List<Feature> features;
}
