package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IPhoneGateway;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.repository.IPhoneRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        if (phoneEntity.getId() != null && phoneRepository.existsById(phoneEntity.getId())) {
            throw new EntityAlreadyExistsException("An entity with this ID already exists: " + phoneEntity.getId());
        }
        PhoneEntity phoneEntitySaved = phoneRepository.save(phoneEntity);
        return phoneEntityMapper.toPhone(phoneEntitySaved);
    }
    @Transactional
    public List<PhoneEntity> saveAllPhoneList(List<PhoneEntity> phoneEntityList){
        try{
            return phoneRepository.saveAll(phoneEntityList);
        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar a lista de phones", e);
        }
    }

    @Override
    public List<Phone> getAllPhones() {
        List<PhoneEntity> phoneEntityList = phoneRepository.findAll();
        return phoneEntityList.stream()
                .map(phoneEntityMapper::toPhone)
                .collect(Collectors.toList());
    }
}
