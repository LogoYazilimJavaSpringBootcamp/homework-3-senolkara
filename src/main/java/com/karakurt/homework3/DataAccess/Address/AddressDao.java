package com.karakurt.homework3.DataAccess.Address;

import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Factories.AddressFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao implements IAddressDao {

    @Override
    public IAddress createAddress(String addr, AddressType addressType) {
        return AddressFactory.createAddress(addr, addressType);
    }
}
