package com.repconnect.api.applicationn.useCase.represented;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.core.domain.Represented;

public class CreateRepresentedUseCase {

    private final IRepresentedGateway iRepresentedGateway;

    public CreateRepresentedUseCase(IRepresentedGateway iRepresentedGateway) {
        this.iRepresentedGateway = iRepresentedGateway;
    }

    public Represented createRepresented(Represented represented){
        return iRepresentedGateway.createRepresented(represented);
    }
}
