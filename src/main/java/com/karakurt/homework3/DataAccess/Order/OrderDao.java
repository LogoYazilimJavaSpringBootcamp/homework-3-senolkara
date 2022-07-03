package com.karakurt.homework3.DataAccess.Order;

import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.Order.OrderCase;
import com.karakurt.homework3.Entities.Order.OrderCaseType;
import com.karakurt.homework3.Entities.Order.OrderStatus;
import com.karakurt.homework3.Factories.OrderFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao implements IOrderDao {
    public static List<IOrder> randomOrders;
    @Override
    public List<IOrder> getOrderList() {
        randomOrders = OrderFactory.createOrder();
        return randomOrders;
    }

    @Override
    public IOrder getOneOrder(List<IOrder> orderList, int index) {
        return orderList.get(index);
    }

    @Override
    public void changeOrderCaseType(OrderCase orderCase, OrderStatus orderStatus, IOrder order) {
        orderCase.setType(OrderCaseType.CREATED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.ORDERED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.SHIPPED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.PURCHASED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.PENDING);
    }

    @Override
    public void setRandomOrders(List<IOrder> randomOrderList) {
        randomOrders = randomOrderList;
    }

    public static Double getTotalAmount(IOrder order){
        return order.getProductList()
                .stream()
                .map(product -> product.getPrice())
                .reduce(0.0,Double::sum);
    }
    public static Double getAverageAmount(IOrder order){
        return getTotalAmount(order) / countOrder(order);
    }
    public static Long countOrder(IOrder order){
        return order.getProductList()
                .stream()
                .map(product -> product.getPrice())
                .count();
    }
}
