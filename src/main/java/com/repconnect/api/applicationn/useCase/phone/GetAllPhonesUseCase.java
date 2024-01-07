package com.repconnect.api.applicationn.useCase.phone;

import com.repconnect.api.applicationn.gateway.IPhoneGateway;
import com.repconnect.api.core.domain.Phone;

import java.util.List;

public class GetAllPhonesUseCase {
    private IPhoneGateway iPhoneGateway;

    public GetAllPhonesUseCase(IPhoneGateway iPhoneGateway) {
        this.iPhoneGateway = iPhoneGateway;
    }

    public List<Phone> getAllPhones(){
        return iPhoneGateway.getAllPhones();
    }
}
