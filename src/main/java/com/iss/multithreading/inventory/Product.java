package com.iss.multithreading.inventory;

public record Product(int id, String name, int quantity, String description) {

    @Override
    public String name() {
        return name.toUpperCase();
    }

}
