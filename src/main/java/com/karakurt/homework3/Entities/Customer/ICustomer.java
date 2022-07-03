package com.karakurt.homework3.Entities.Customer;

import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.User.IUser;
import com.karakurt.homework3.Needs.DateOperations;

public interface ICustomer extends DateOperations {
    Integer getId();
    void setId(Integer id);
    IUser getIUser();
    void setIUser(IUser iUser);
    IOrder getOrder();
    void setOrder(IOrder order);
}
