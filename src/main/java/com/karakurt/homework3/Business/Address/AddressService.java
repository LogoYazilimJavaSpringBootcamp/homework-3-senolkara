package com.karakurt.homework3.Business.Address;

import com.karakurt.homework3.DataAccess.Address.IAddressDao;
import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.Address.IAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {

    private final IAddressDao iAddressDao;

    @Override
    public IAddress createAddress(String addr, AddressType addressType) {
        return this.iAddressDao.createAddress(addr, addressType);
    }
}
