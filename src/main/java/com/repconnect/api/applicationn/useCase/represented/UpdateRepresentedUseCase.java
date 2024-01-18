package com.repconnect.api.applicationn.useCase.represented;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.core.domain.Represented;

public class UpdateRepresentedUseCase {

    private final IRepresentedGateway iRepresentedGateway;


    public UpdateRepresentedUseCase(IRepresentedGateway iRepresentedGateway) {
        this.iRepresentedGateway = iRepresentedGateway;
    }

    public Represented updateRepresented(Represented represented){
        return iRepresentedGateway.updateRepresented(represented);
    }
}
