package com.quickbite.businesslogic.Entities.Rating;

public enum ScoreEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private final int value;

    ScoreEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
