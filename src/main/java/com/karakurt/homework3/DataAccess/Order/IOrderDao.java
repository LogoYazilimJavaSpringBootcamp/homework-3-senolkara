package com.karakurt.homework3.DataAccess.Order;

import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.Order.OrderCase;
import com.karakurt.homework3.Entities.Order.OrderStatus;
import com.karakurt.homework3.Entities.Product.IProduct;

import java.util.List;

public interface IOrderDao {
    List<IOrder> getOrderList();
    IOrder getOneOrder(List<IOrder> orderList, int index);
    void changeOrderCaseType(OrderCase orderCase, OrderStatus orderStatus, IOrder order);
    void setRandomOrders(List<IOrder> randomOrderList);
}
