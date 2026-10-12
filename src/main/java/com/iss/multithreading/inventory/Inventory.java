package com.iss.multithreading.inventory;

public class Inventory {

    public static String update(Product product) throws InterruptedException {
        Thread.sleep(1000);
        return "Product id: " + product.id() + ", has been updated";
    }

}
