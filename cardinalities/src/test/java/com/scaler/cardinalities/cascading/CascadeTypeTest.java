package com.scaler.cardinalities.cascading;

import com.scaler.cardinalities.builder.CategoryBuilder;
import com.scaler.cardinalities.builder.ProductBuilder;
import com.scaler.cardinalities.models.Category;
import com.scaler.cardinalities.models.Currency;
import com.scaler.cardinalities.models.Price;
import com.scaler.cardinalities.models.Product;
import com.scaler.cardinalities.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
@SpringBootTest
public class CascadeTypeTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCascadeTypeAll(){
        Price price1 = new Price();
        price1.setCurrency(Currency.INR);
        price1.setAmount(9.0);
        Price price2 = new Price();
        price1.setCurrency(Currency.INR);
        price1.setAmount(10.0);
        Product product1 = ProductBuilder.getInstance()
                .setName("Iphone16")
                .setDescription("Iphone 16 2020")
                .setPrice(price1)
                .build();
        Product product2 = ProductBuilder.getInstance()
                .setName("Iphone17")
                .setDescription("Iphone 17 2020")
                .setPrice(price2)
                .build();
        Category category = CategoryBuilder.getInstance()
                .setName("Mobile")
                .setDescription("Touch screen phones")
                .setProducts(Arrays.asList(product1,product2))
                .build();
        categoryRepository.save(category);
        System.out.println("Category from test generated ID: "+category.getId());
        System.out.println("Product 1 from test generated ID: "+category.getProducts().get(0).getId());
        System.out.println("Product 2 from test generated ID: "+category.getProducts().get(1).getId());
        categoryRepository.delete(category);
    }

}
