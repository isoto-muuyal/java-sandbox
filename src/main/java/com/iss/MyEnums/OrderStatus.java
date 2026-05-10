package com.iss.MyEnums;

public enum OrderStatus {

    NEW(1, "New"),
    ON_HOLD(2, "on hold"),
    IN_PROGRESS(3, "In Progress"),
    SHIPPED(4, "Shipped"),
    DELIVERED(5, "Delivered"),
    CANCELLED(6, "Cancelled");

    private final int code;
    private final String label;

    OrderStatus(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
