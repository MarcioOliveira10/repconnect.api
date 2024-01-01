package com.repconnect.api.applicationn.useCase;

import com.repconnect.api.applicationn.gateway.IAddressGateway;
import com.repconnect.api.core.domain.Address;

public class CreateAddressUseCase {
    private IAddressGateway IAddressGateway;

    public CreateAddressUseCase(IAddressGateway IAddressGateway) {
        this.IAddressGateway = IAddressGateway;
    }

    public Address createAddress(Address address) {

        return IAddressGateway.createAddress(address);
    }

}
