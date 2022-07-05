package com.karakurt.homework3.Entities.User;

import com.karakurt.homework3.Entities.Address.Address;
import com.karakurt.homework3.Entities.Address.IAddress;

public interface IUser {
    Long getId();
    void setId(Long id);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getEmail();
    void setEmail(String email);
    Address getAddress();
    void setAddress(Address address);
}
