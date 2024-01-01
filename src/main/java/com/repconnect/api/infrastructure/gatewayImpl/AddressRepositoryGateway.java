package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IAddressGateway;
import com.repconnect.api.core.domain.Address;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.mapper.AddressEntityMapper;
import com.repconnect.api.infrastructure.repository.IAddressRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        if (addressEntity.getId() != null && addressRepository.existsById(addressEntity.getId())) {
            throw new EntityAlreadyExistsException("O ID " + addressEntity.getId() + " já existe na base de dados");
        }
        AddressEntity savedObj = addressRepository.save(addressEntity);
        return addressEntityMapper.toAddress(savedObj);
    }

    @Override
    public List<Address> getAllAddresses() {
        List<AddressEntity> addressEntities = addressRepository.findAll();
        return addressEntities.stream()
                .map(addressEntityMapper::toAddress)
                .collect(Collectors.toList());
    }
}
