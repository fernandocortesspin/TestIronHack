package com.fernando.lab.two.entity;

import com.fernando.lab.two.constant.OrderType;

import java.math.BigDecimal;

public class Order {

    OrderType type;

    BigDecimal amount;

    int priority;

    int quantity;

    public OrderType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPriority() {
        return priority;
    }

    public int getQuantity() {
        return quantity;
    }

}
