package com.karakurt.homework3.Entities.Order;

public enum OrderStatus {
    PENDING {
        public OrderStatus nextStatus(OrderCase orderCase){
            if (orderCase.getType() == OrderCaseType.PENDING)
                return OrderStatus.CREATED;
            throw new IllegalArgumentException("Geçersiz sipariş durumu: " + orderCase);
        }
    },
    CREATED {
        public OrderStatus nextStatus(OrderCase orderCase){
            if (orderCase.getType() == OrderCaseType.CREATED)
                return OrderStatus.ORDERED;
            throw new IllegalArgumentException("Geçersiz sipariş durumu: " + orderCase);
        }
    },
    ORDERED{
        public OrderStatus nextStatus(OrderCase orderCase){
            if (orderCase.getType() == OrderCaseType.ORDERED)
                return OrderStatus.PURCHASED;
            throw new IllegalArgumentException("Geçersiz sipariş durumu: " + orderCase);
        }
    },
    PURCHASED{
        public OrderStatus nextStatus(OrderCase orderCase){
            if (orderCase.getType() == OrderCaseType.PURCHASED)
                return OrderStatus.SHIPPED;
            throw new IllegalArgumentException("Geçersiz sipariş durumu: " + orderCase);
        }
    },
    SHIPPED{
        public OrderStatus nextStatus(OrderCase orderCase){
            if (orderCase.getType() == OrderCaseType.SHIPPED)
                return OrderStatus.DELIVERED;
            throw new IllegalArgumentException("Geçersiz sipariş durumu: " + orderCase);
        }
    },
    DELIVERED{
        public OrderStatus nextStatus(OrderCase orderCase){
            if (orderCase.getType() == OrderCaseType.DELIVERED)
                return OrderStatus.PENDING;
            throw new IllegalArgumentException("Geçersiz sipariş durumu: " + orderCase);
        }
    };

    public abstract OrderStatus nextStatus(OrderCase orderCase);
}
