package com.scaler.cardinalities.builder;

import com.scaler.cardinalities.models.Category;
import com.scaler.cardinalities.models.Price;
import com.scaler.cardinalities.models.Product;

public class ProductBuilder {
    private String name;
    private String description;
    private Category category;
    private Price price;

    private ProductBuilder(){
    }
    public ProductBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ProductBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public ProductBuilder setCategory(Category category){
        this.category = category;
        return this;
    }

    public ProductBuilder setPrice(Price price){
        this.price = price;
        return this;
    }
    public Product build(){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);
        return product;
    }

    public static ProductBuilder getInstance(){
        return new ProductBuilder();
    }
}
