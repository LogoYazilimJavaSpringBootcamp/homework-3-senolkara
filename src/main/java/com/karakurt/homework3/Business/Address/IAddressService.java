package com.karakurt.homework3.Business.Address;

import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.Address.IAddress;

public interface IAddressService {
    IAddress createAddress(String addr, AddressType addressType);
}
