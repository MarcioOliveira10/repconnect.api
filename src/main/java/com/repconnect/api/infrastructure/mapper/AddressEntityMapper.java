package com.repconnect.api.infrastructure.mapper;

import com.repconnect.api.core.domain.Address;
import com.repconnect.api.infrastructure.entity.AddressEntity;

public class AddressEntityMapper {

    public AddressEntity toEntity(Address address) {
        return new AddressEntity(
                address.street(),
                address.number(),
                address.city(),
                address.zipCode(),
                address.complement(),
                address.createdAt(),
                address.updatedAt());
    }

    public Address toAddress(AddressEntity addressEntity) {
        return new Address(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getCity(),
                addressEntity.getZipCode(),
                addressEntity.getComplement(),
                addressEntity.getCreatedAt(),
                addressEntity.getUpdatedAt());
    }
}
