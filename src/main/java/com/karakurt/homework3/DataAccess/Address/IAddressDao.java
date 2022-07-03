package com.karakurt.homework3.DataAccess.Address;

import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.Address.IAddress;

public interface IAddressDao {
    IAddress createAddress(String addr, AddressType addressType);
}
