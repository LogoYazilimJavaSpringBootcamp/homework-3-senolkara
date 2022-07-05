package com.karakurt.homework3.DataAccess.Address;

import com.karakurt.homework3.Entities.Address.Address;
import com.karakurt.homework3.Entities.Address.AddressType;

public interface IAddressDao {
    Address createAddress(String addr, AddressType addressType);
}
