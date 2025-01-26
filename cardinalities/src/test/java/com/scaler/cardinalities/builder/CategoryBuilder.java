package com.scaler.cardinalities.builder;

import com.scaler.cardinalities.models.Category;
import com.scaler.cardinalities.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryBuilder {
    private String name;
    private String description;
    private List<Product> products;

    private CategoryBuilder(){
    }
    public CategoryBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CategoryBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public CategoryBuilder setProducts(List<Product> products){
        this.products = products;
        return this;
    }
    public CategoryBuilder setProduct(Product product){
        if(this.products == null){
            this.products = new ArrayList<>();
        }
        this.products.add(product);
        return this;
    }

    public Category build(){
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setProducts(products);
        return category;
    }

    public static CategoryBuilder getInstance(){
        return new CategoryBuilder();
    }
}
