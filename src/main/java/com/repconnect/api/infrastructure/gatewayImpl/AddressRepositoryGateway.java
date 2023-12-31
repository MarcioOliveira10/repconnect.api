package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IAddressGateway;
import com.repconnect.api.core.domain.Address;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.mapper.AddressEntityMapper;
import com.repconnect.api.infrastructure.repository.IAddressRepository;

public class AddressRepositoryGateway implements IAddressGateway {

    private final IAddressRepository addressRepository;

    private final AddressEntityMapper addressEntityMapper;

    public AddressRepositoryGateway(IAddressRepository IAddressRepository, AddressEntityMapper addressEntityMapper) {
        this.addressRepository = IAddressRepository;
        this.addressEntityMapper = addressEntityMapper;
    }

    @Override
    public Address createAddress(Address address) {
        AddressEntity addressEntity = addressEntityMapper.toEntity(address);
        AddressEntity savedObj = addressRepository.save(addressEntity);
        return addressEntityMapper.toAddress(savedObj);
    }
}
