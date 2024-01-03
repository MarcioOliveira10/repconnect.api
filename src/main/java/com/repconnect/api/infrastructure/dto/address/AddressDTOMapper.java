package com.repconnect.api.infrastructure.dto.address;

import com.repconnect.api.core.domain.Address;

public class AddressDTOMapper {

    public AddressResponse toResponse(Address address){
        return new AddressResponse(
                address.street(),
                address.number(),
                address.city(),
                address.zipCode(),
                address.complement(),
                address.createdAt());
    }

    public Address toAddress(AddressRequest request){
        return new Address(
                request.id(),
                request.street(),
                request.number(),
                request.city(),
                request.zipCode(),
                request.complement(),
                request.createAt(),
                request.updatedAt()
        );
    }
}
