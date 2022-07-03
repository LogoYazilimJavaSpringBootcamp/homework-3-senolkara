package com.karakurt.homework3.Entities.Order;

import com.karakurt.homework3.Entities.Product.IProduct;
import com.karakurt.homework3.Needs.DateOperations;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Order implements IOrder {
    private LocalDate createdDT = DateOperations.createdDT;
    private OrderStatus orderStatus;
    private List<IProduct> productList;
    public Order() {
        this.orderStatus = OrderStatus.PENDING;
    }
    @Override
    public void addProduct(IProduct product) {
        productList.add(product);
    }
    @Override
    public OrderStatus ongoing(OrderCase orderCase) {
        if(this.orderStatus == null)
            this.orderStatus = OrderStatus.PENDING;

        this.orderStatus = orderStatus.nextStatus(orderCase);

        return this.orderStatus;
    }
    @Override
    public LocalDate getCreatedDT(){
        return createdDT;
    }
    @Override
    public void setCreatedDT(LocalDate createdDT){
        this.createdDT = createdDT;
    }
    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    @Override
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public List<IProduct> getProductList() {
        return productList;
    }
    @Override
    public void setProductList(List<IProduct> productList) {
        this.productList = productList;
    }
    @Override
    public String toString() {
        return "Order{" +
                ", orderStatus=" + this.orderStatus +
                ", products=" + this.productList +
                ", createdDateTime=" + this.createdDT +
                '}';
    }
}
