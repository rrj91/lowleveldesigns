package com.scaler.jpainheritence3.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Instructor extends User{
    private double instructor_rating;

    public double getInstructor_rating() {

        return instructor_rating;
    }

    public void setInstructor_rating(double instructor_rating) {
        this.instructor_rating = instructor_rating;
    }
}
