package com.karakurt.homework3.Factories;

import com.karakurt.homework3.DataAccess.Product.ProductDao;
import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.Order.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderFactory {
    public static List<IOrder> createOrder(){
        List<IOrder> orderList = new ArrayList<>();
        ProductDao productDao = new ProductDao();
        for (int i = 0; i < productDao.getProductList().size(); i++) {
            IOrder order = new Order();
            order.setProductList(productDao.getProductList());
            LocalDate localDate = LocalDate.now();
            order.setCreatedDT(localDate);
            orderList.add(order);
        }
        return orderList;
    }
}
