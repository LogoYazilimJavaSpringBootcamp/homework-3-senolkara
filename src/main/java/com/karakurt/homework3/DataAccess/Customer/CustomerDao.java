package com.karakurt.homework3.DataAccess.Customer;

import com.karakurt.homework3.DataAccess.Order.IOrderDao;
import com.karakurt.homework3.DataAccess.Order.OrderDao;
import com.karakurt.homework3.DataAccess.User.UserDao;
import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.Customer.Customer;
import com.karakurt.homework3.Entities.Customer.ICustomer;
import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.Order.OrderCase;
import com.karakurt.homework3.Entities.Order.OrderCaseType;
import com.karakurt.homework3.Entities.Order.OrderStatus;
import com.karakurt.homework3.Entities.User.IUser;
import com.karakurt.homework3.Needs.DateOperations;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class CustomerDao implements ICustomerDao {
    LocalDate registerDate = DateOperations.registerDate;
    public List<IUser> randomUsers;
    public static List<ICustomer> randomCustomers;

    public CustomerDao(){
        if (randomCustomers == null){
            UserDao userDao = new UserDao();
            randomUsers = userDao.getRandomUsers();
            List<ICustomer> randomCustomerList = getRandomCustomers();
            setRandomCustomers(randomCustomerList);
        }
    }

    public List<ICustomer> getRandomCustomers() {
        List<ICustomer> customerList = new ArrayList<>();
        List<IUser> randomUsers = this.randomUsers;
        OrderCase orderCase = new OrderCase();
        orderCase.setType(OrderCaseType.PENDING);
        IOrderDao iOrderDao = new OrderDao();
        Integer id = 1;
        for (IUser iUser: randomUsers){
            List<IOrder> orderList = iOrderDao.getOrderList();
            int randomKey = new Random().nextInt(orderList.size() - 1);
            IOrder order = iOrderDao.getOneOrder(orderList,randomKey);
            ICustomer customer = new Customer(id, iUser, order, registerDate);

            customerList.add(customer);
            OrderStatus orderStatus = order.ongoing(orderCase);
            iOrderDao.changeOrderCaseType(orderCase, orderStatus, order);
            id++;
        }
        return customerList;
    }

    @Override
    public List<ICustomer> getCustomerList(){
        return randomCustomers;
    }

    @Override
    public ICustomer createCustomer(String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT) {
        IUser iUser = createUser(firstName, lastName, email, address);
        Integer id = randomCustomers.size() + 1;
        ICustomer iCustomer = new Customer(id, iUser, order, createdDT);
        randomCustomers.add(iCustomer);
        return iCustomer;
    }

    @Override
    public ICustomer updateCustomer(Integer id, String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT) {
        UserDao userDao = new UserDao();
        IAddress iAddress = userDao.createAddress(address);
        List<ICustomer> iCustomerList = getCustomerList();
        ICustomer iCustomer = iCustomerList.get(id - 1);
        IUser iUser = iCustomer.getIUser();
        iUser.setFirstName(firstName);
        iUser.setLastName(lastName);
        iUser.setEmail(email);
        iUser.setIAddress(iAddress);
        iCustomer.setIUser(iUser);
        iCustomer.setOrder(order);
        iCustomer.setCreatedDT(createdDT);
        return iCustomer;
    }

    @Override
    public void deleteCustomer(Integer id) {
        randomCustomers.remove(id - 1);
    }

    public void setRandomCustomers(List<ICustomer> randomCustomerList) {
        randomCustomers = randomCustomerList;
    }

    public IUser createUser(String firstName, String lastName, String email, String address){
        UserDao userDao = new UserDao();
        IUser iUser = userDao.createUser(firstName, lastName, email, address);
        return iUser;
    }
}
