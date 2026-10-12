package com.iss.multithreading;

import com.iss.multithreading.inventory.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

    @Autowired
    private static ProductService productService = new ProductService();

    public static void main(String[] args) throws Exception {

        //let's imagine the user is logged in
        User user = new User(1, "Juan Perez", Role.USER);

        //get items to update
        List<Product> products = productService.getProducts(LocalDate.now(), user);

        //prepare executor
        ExecutorService executorService = Executors.newFixedThreadPool(products.size());
        List<Callable<String>> tasks = new ArrayList<>();

        //define tasks
        for (Product product : products) {
            tasks.add( () -> Inventory.update(product));
        }

        //running tasks
        System.out.println("starting parallel testing");
        long startTime = System.nanoTime();

        List<Future<String>> results = executorService.invokeAll(tasks);

        for (Future result : results) {
            System.out.println("Result: " + result.get());
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Total time: " + totalTime/1000000 + " ms");
        System.out.println("Average time: " + (totalTime/tasks.size())/1000000 + " ms per task");
    }

}
