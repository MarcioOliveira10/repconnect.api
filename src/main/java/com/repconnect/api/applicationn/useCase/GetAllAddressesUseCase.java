package com.repconnect.api.applicationn.useCase;

import com.repconnect.api.applicationn.gateway.IAddressGateway;
import com.repconnect.api.core.domain.Address;
import java.util.List;

public class GetAllAddressesUseCase {
    private IAddressGateway iAddressGateway;

    public GetAllAddressesUseCase(IAddressGateway iAddressGateway) {
        this.iAddressGateway = iAddressGateway;
    }

    public List<Address> getAllAddresses(){
        return iAddressGateway.getAllAddresses();
    }
}
