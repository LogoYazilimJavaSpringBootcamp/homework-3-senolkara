package com.karakurt.homework3.Entities.Order;

public class OrderCase {
    private OrderCaseType type;
    public OrderCaseType getType() {
        return type;
    }
    public void setType(OrderCaseType type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "OrderCase{" +
                ", type=" + this.type +
                '}';
    }
}
