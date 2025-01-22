package com.scaler.cardinalities.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product extends BaseModel{
    private String name;
    private String description;

    @ManyToOne
    private Category category;

//    @OneToOne
//    private Price price;

//    public Price getPrice() {
//        return price;
//    }
//
//    public void setPrice(Price price) {
//        this.price = price;
//    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
