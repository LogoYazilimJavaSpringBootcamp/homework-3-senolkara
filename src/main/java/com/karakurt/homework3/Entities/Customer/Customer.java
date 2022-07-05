package com.karakurt.homework3.Entities.Customer;

import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.Order.IOrder;
import com.karakurt.homework3.Entities.User.IUser;
import com.karakurt.homework3.Needs.DateOperations;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer implements ICustomer {
    private Long id;
    private IUser iUser;
    private IOrder order;
    private LocalDate createdDT = DateOperations.createdDT;

    @Override
    public LocalDate getCreatedDT() {
        return createdDT;
    }
    @Override
    public void setCreatedDT(LocalDate createdDT) {
        this.createdDT = createdDT;
    }

    @Override
    public IUser getIUser() {
        return this.iUser;
    }

    @Override
    public void setIUser(IUser iUser) {
        this.iUser = iUser;
    }
}
