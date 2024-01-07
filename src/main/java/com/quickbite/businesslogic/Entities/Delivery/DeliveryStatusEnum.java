package com.quickbite.businesslogic.Entities.Delivery;

public enum DeliveryStatusEnum {
    PENDING("Pending"),
    IN_TRANSIT("In Transit"),
    DELIVERED("Delivered"),
    FAILED("Delivery Failed"),
    RETURNED("Returned");

    private final String value;

    DeliveryStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
