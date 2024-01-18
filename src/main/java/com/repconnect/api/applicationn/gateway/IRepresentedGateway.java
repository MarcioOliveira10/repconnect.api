package com.repconnect.api.applicationn.gateway;

import com.repconnect.api.core.domain.Represented;

import java.util.List;

public interface IRepresentedGateway {

    Represented createRepresented(Represented represented);

    List<Represented> getAllRepresented();

    Represented updateRepresented(Represented represented);
}
