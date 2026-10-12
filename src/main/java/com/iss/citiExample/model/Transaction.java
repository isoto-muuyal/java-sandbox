package com.iss.citiExample.model;

public class Transaction {

    private String id;
    private double amount;
    private String status; // Can be "CLEARED", "PENDING", or "FAILED"

    // Constructor, Getters, and Setters are already implemented
    public Transaction(String id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

}
