package com.scaler.cardinalities.service;

import com.scaler.cardinalities.models.*;
import com.scaler.cardinalities.repository.CategoryRepository;
import com.scaler.cardinalities.repository.OrderRepository;
import com.scaler.cardinalities.repository.PriceRepository;
import com.scaler.cardinalities.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InitializationService {

    //private PriceRepository priceRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
   // private OrderRepository orderRepository;

    @Autowired
    public InitializationService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        //this.priceRepository = priceRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        //this.orderRepository = orderRepository;
    }

    public void init(){
        Price price1 = new Price();
        price1.setCurrency(Currency.INR);
        price1.setAmount(100.0);

        Price price2 = new Price();
        price2.setCurrency(Currency.INR);
        price2.setAmount(101.0);
        Price price3 = new Price();
        price3.setCurrency(Currency.INR);
        price3.setAmount(102.2);

        //priceRepository.saveAll(Arrays.asList(price1,price2,price3));

        Category category1 = new Category();
        category1.setDescription("Mobile phones");
        category1.setName("Mobile");
        Category category2 = new Category();
        category2.setDescription("Laptops and Macs");
        category2.setName("Mac and Laps");

        category1 =categoryRepository.save(category1);
        category2 = categoryRepository.save(category2);
        System.out.println("category1: "+category1.getId());
        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setName("Iphone");
        //product1.setPrice(price1);

        Product product2 = new Product();
        product2.setCategory(category1);
        product2.setName("Nokia");
        //product2.setPrice(price2);

        Product product3 = new Product();
        product3.setCategory(category2);
        product3.setName("Macbook");
        //product3.setPrice(price3);
        category1.setProducts(Arrays.asList(product1,product3));
        category2.setProducts(Arrays.asList(product2));

        productRepository.saveAll(Arrays.asList(product1,product2,product3));
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        System.out.println("Product1: "+product1.getId());
        System.out.println("Product2: "+product2.getId());
        System.out.println("Product3: "+product3.getId());
//        Order order = new Order();
//        order.setProducts(Arrays.asList(product1,product2,product3));
//        orderRepository.save(order);
//        category1 = categoryRepository.findById(category1.getId()).get();
//        categoryRepository.delete(category1);
    }
}
