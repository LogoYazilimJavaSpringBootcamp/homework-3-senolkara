package com.karakurt.homework3.Factories;

import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.Address.BillingAddress;
import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.Address.ShippingAddress;

public class AddressFactory {
    public static IAddress createAddress(String addr, AddressType addressType){
        IAddress address;
        switch (addressType){
            case BILLING -> {
                address = new BillingAddress();
            }
            case SHIPPING -> {
                address = new ShippingAddress();
            }
            default -> {
                throw new RuntimeException("AddressType not found");
            }
        }
        address.setAddress(addr);
        address.setAddressType(addressType);
        return address;
    }
}
