package com.repconnect.api.applicationn.gateway;

import com.repconnect.api.core.domain.Address;

import java.util.Collection;
import java.util.List;

public interface IAddressGateway {
    Address createAddress(Address address);

    public List<Address> getAllAddresses();
}
