package com.repconnect.api.infrastructure.dto.represented;

import com.repconnect.api.core.domain.Represented;

public class RepresentedDTOMapper {

    public RepresentedResponse toResponse(Represented represented){
        return new RepresentedResponse(
                represented.name(),
                represented.webSite(),
                represented.email(),
                represented.address(),
                represented.phones(),
                represented.createdAt(),
                represented.updatedAt()
        );
    }

    public Represented toRepresented(RepresentedRequest request){
        return new Represented(
                request.id(),
                request.name(),
                request.webSite(),
                request.email(),
                request.address(),
                request.phones(),
                request.createdAt(),
                request.updatedAt()
        );
    }
}
