package com.karakurt.homework3.Entities.Order;

import com.karakurt.homework3.Entities.Product.IProduct;
import com.karakurt.homework3.Needs.DateOperations;

import java.util.List;

public interface IOrder extends DateOperations {
    List<IProduct> getProductList();
    void setProductList(List<IProduct> productList);
    OrderStatus getOrderStatus();
    void setOrderStatus(OrderStatus orderStatus);
    void addProduct(IProduct iProduct);
    OrderStatus ongoing(OrderCase orderCase);
}
