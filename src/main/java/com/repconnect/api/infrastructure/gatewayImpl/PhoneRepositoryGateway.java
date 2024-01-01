package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IPhoneGateway;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.repository.IPhoneRepository;

public class PhoneRepositoryGateway implements IPhoneGateway {

    private final IPhoneRepository phoneRepository;

    private final PhoneEntityMapper phoneEntityMapper;

    public PhoneRepositoryGateway(IPhoneRepository phoneRepository, PhoneEntityMapper phoneEntityMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneEntityMapper = phoneEntityMapper;
    }



    @Override
    public Phone createPhone(Phone phone) {
        PhoneEntity phoneEntity = phoneEntityMapper.toEntity(phone);
        if (phoneEntity.getId() != null && phoneRepository.existsById(phoneEntity.getId())){
            throw new EntityAlreadyExistsException("An entity with this ID already exists: " + phoneEntity.getId());
        }
        PhoneEntity phoneEntitySaved = phoneRepository.save(phoneEntity);
        return phoneEntityMapper.toPhone(phoneEntitySaved);
    }
}
