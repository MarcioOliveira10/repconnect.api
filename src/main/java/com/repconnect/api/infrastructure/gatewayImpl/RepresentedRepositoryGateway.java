package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.core.exception.IllegalArgumentException;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.entity.RepresentedEntity;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.mapper.RepresentedEntityMapper;
import com.repconnect.api.infrastructure.repository.IRepresentedRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class RepresentedRepositoryGateway implements IRepresentedGateway {

    private final IRepresentedRepository iRepresentedRepository;
    private final RepresentedEntityMapper representedEntityMapper;
    private final PhoneRepositoryGateway phoneRepositoryGateway;


    public RepresentedRepositoryGateway(IRepresentedRepository iRepresentedRepository, RepresentedEntityMapper representedEntityMapper, PhoneRepositoryGateway phoneRepositoryGateway, PhoneEntityMapper phoneEntityMapper) {
        this.iRepresentedRepository = iRepresentedRepository;
        this.representedEntityMapper = representedEntityMapper;
        this.phoneRepositoryGateway = phoneRepositoryGateway;
    }
    @Override
    @Transactional
    public Represented createRepresented(Represented represented){
            RepresentedEntity representedEntity = representedEntityMapper.toRepresentedEntity(represented);
            if(representedEntity.getName() != null && iRepresentedRepository.existsByNameIgnoringSpaces(representedEntity.getName())){
                throw new EntityAlreadyExistsException("An entity with this name already exists: " + representedEntity.getName());
            }
            try {
                RepresentedEntity savedRepresentedEntity = iRepresentedRepository.save(representedEntity);
                List<PhoneEntity> phoneEntityList = representedEntity.getPhones();
                if (phoneEntityList != null && !phoneEntityList.isEmpty()){
                    for(PhoneEntity phoneEntity : phoneEntityList){
                        phoneEntity.setRepresented(savedRepresentedEntity);
                    }
                    phoneRepositoryGateway.saveAllPhoneList(phoneEntityList);
                }
                return representedEntityMapper.toRepresented(savedRepresentedEntity);
            }catch (IllegalArgumentException ex){
                ex.printStackTrace();
                throw new IllegalArgumentException("Error saving Represented");
            }

    }

    @Override
    public List<Represented> getAllRepresented() {
        List<RepresentedEntity> representedEntityList = iRepresentedRepository.findAll();
        return representedEntityList.stream()
                .map(representedEntityMapper::toRepresented)
                .collect(Collectors.toList());
    }
}
