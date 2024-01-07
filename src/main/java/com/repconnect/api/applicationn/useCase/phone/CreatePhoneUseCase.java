package com.repconnect.api.applicationn.useCase.phone;

import com.repconnect.api.applicationn.gateway.IPhoneGateway;
import com.repconnect.api.core.domain.Phone;

public class CreatePhoneUseCase {
    private IPhoneGateway iPhoneGateway;

    public CreatePhoneUseCase(IPhoneGateway iPhoneGateway) {
        this.iPhoneGateway = iPhoneGateway;
    }

    public Phone createPhone(Phone phone){
        return iPhoneGateway.createPhone(phone);
    }
}
