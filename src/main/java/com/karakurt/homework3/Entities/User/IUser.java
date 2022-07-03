package com.karakurt.homework3.Entities.User;

import com.karakurt.homework3.Entities.Address.IAddress;

public interface IUser {
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getEmail();
    void setEmail(String email);
    IAddress getIAddress();
    void setIAddress(IAddress iAddress);
}
