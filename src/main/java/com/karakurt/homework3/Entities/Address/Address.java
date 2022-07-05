package com.karakurt.homework3.Entities.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address implements IAddress, Serializable {
    private Long id;
    private String address;
    private AddressType addressType;
}
