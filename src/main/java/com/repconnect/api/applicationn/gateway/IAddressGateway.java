package com.repconnect.api.applicationn.gateway;

import com.repconnect.api.core.domain.Address;

public interface IAddressGateway {
    Address createAddress(Address address);
}
