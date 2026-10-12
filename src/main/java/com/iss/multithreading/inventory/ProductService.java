package com.iss.multithreading.inventory;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts(LocalDate date, User user) {
        //simulate we are doing some db call for user and date
        return List.of(new Product(1, "cafe", 3, "cafe en bolsa"),
                new Product(2, "soda", 6, "coquita"),
                new Product(3, "Pizza", 2, "llegaron las picsas"));

    }

}
