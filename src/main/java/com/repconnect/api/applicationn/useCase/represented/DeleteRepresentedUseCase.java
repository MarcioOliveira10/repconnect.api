package com.repconnect.api.applicationn.useCase.represented;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;

public class DeleteRepresentedUseCase {

    public final IRepresentedGateway iRepresentedGateway;

    public DeleteRepresentedUseCase(IRepresentedGateway iRepresentedGateway) {
        this.iRepresentedGateway = iRepresentedGateway;
    }

    public void deleteRepresentedUseCase(Integer id){
        iRepresentedGateway.deleteById(id);

    }
}
