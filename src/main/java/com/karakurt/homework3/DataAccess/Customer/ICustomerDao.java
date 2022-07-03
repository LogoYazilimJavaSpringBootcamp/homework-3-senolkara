package com.karakurt.homework3.DataAccess.Customer;

import com.karakurt.homework3.Entities.Customer.ICustomer;
import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.User.IUser;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerDao {
    List<ICustomer> getCustomerList();
    ICustomer createCustomer(String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT);
    ICustomer updateCustomer(Integer id, String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT);
    void deleteCustomer(Integer id);
}
