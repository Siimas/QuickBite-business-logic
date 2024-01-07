package com.quickbite.businesslogic.Entities.Payment;

public enum PaymentStatusEnum {
    PENDING("Pending"),
    SUCCESS("Success"),
    FAILED("Failed"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded");

    private final String value;

    PaymentStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
