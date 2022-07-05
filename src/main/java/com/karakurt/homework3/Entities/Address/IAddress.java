package com.karakurt.homework3.Entities.Address;

public interface IAddress {
    Long getId();
    void setId(Long id);
    String getAddress();
    void setAddress(String address);
    AddressType getAddressType();
    void setAddressType(AddressType addressType);
}
