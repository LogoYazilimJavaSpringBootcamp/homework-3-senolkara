package com.karakurt.homework3.DataAccess.Address;

import com.karakurt.homework3.Entities.Address.Address;
import com.karakurt.homework3.Entities.Address.AddressType;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao implements IAddressDao {

    @Override
    public Address createAddress(String addr, AddressType addressType) {
        Address address1 = new Address();
        address1.setAddress(addr);
        address1.setAddressType(AddressType.BILLING);
        return address1;
    }
}
