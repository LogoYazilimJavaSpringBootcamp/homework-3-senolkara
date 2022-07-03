package com.karakurt.homework3.Business.Order;

import com.karakurt.homework3.DataAccess.Order.IOrderDao;
import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.Order.OrderCase;
import com.karakurt.homework3.Entities.Order.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderDao iOrderDao;

    @Override
    public List<IOrder> getOrderList() {
        return iOrderDao.getOrderList();
    }

    @Override
    public IOrder getOneOrder(List<IOrder> orderList, int index) {
        return this.iOrderDao.getOneOrder(orderList, index);
    }

    @Override
    public void changeOrderCaseType(OrderCase orderCase, OrderStatus orderStatus, IOrder order) {
        this.iOrderDao.changeOrderCaseType(orderCase, orderStatus, order);
    }
}
