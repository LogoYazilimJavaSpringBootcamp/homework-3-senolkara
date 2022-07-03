package com.karakurt.homework3.Business.Order;

import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.Order.OrderCase;
import com.karakurt.homework3.Entities.Order.OrderStatus;

import java.util.List;

public interface IOrderService {
    List<IOrder> getOrderList();
    IOrder getOneOrder(List<IOrder> orderList, int index);
    void changeOrderCaseType(OrderCase orderCase, OrderStatus orderStatus, IOrder order);
}
