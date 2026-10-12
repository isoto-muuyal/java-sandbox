package com.iss.multithreading;

import com.iss.multithreading.inventory.*;

import java.time.LocalDate;
import java.util.List;

public class CompletableFutureExample {

    private static ProductService productService = new ProductService();

    public static void main(String[] args) {

        User user = new User(2, "Mario Bros", Role.MANAGER);
        List<Product> productList = productService.getProducts(LocalDate.now(), user);

        System.out.println("Starting parallel updates...");
        long startTime = System.currentTimeMillis();

    }

}
