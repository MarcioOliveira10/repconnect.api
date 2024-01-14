package com.repconnect.api.applicationn.useCase.represented;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.core.domain.Represented;

import java.util.List;

public class GetAllRepresentedUseCase {

    private final IRepresentedGateway iRepresentedGateway;

    public GetAllRepresentedUseCase(IRepresentedGateway iRepresentedGateway) {
        this.iRepresentedGateway = iRepresentedGateway;
    }

    public List<Represented> getAllRepresented(){
        return iRepresentedGateway.getAllRepresented();
    }
}
