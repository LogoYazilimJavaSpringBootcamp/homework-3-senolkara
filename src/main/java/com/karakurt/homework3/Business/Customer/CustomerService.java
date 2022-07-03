package com.karakurt.homework3.Business.Customer;

import com.karakurt.homework3.DataAccess.Customer.ICustomerDao;
import com.karakurt.homework3.Entities.Customer.ICustomer;
import com.karakurt.homework3.Entities.Order.IOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerDao iCustomerDao;

    @Override
    public List<ICustomer> getCustomerList() {
        return this.iCustomerDao.getCustomerList();
    }

    @Override
    public ICustomer createCustomer(String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT) {
        return this.iCustomerDao.createCustomer(firstName, lastName, email, address, order, createdDT);
    }

    @Override
    public ICustomer updateCustomer(Integer id, String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT) {
        return this.iCustomerDao.updateCustomer(id, firstName, lastName, email, address, order, createdDT);
    }

    @Override
    public void deleteCustomer(Integer id) {
        this.iCustomerDao.deleteCustomer(id);
    }
}
