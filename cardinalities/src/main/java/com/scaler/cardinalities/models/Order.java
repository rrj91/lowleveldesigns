package com.scaler.cardinalities.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;



//@Entity(name = "ecomm_order")
public class Order extends BaseModel{
    @ManyToMany
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
