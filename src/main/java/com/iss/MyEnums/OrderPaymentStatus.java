package com.iss.MyEnums;

public enum OrderPaymentStatus {

    PENDING_PAYMENT(1, "Pending Payment"),
    PROCESSING_PAYMENT(2, "Processing Payment"),
    PAYMENT_REJECTED(3, "Payment Rejected"),
    PAYED(4, "Payed");

    private final int code;
    private final String label;

    OrderPaymentStatus(int code, String label) {
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
