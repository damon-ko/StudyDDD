package com.study.ddd.domain.order;

public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int value) {
        return new Money(this.value * value);
    }
}
