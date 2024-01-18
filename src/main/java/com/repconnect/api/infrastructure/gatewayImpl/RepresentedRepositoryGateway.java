package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.core.exception.EntityAlreadyExistsException;
import com.repconnect.api.core.exception.EntityNotFoundExceptions;
import com.repconnect.api.core.exception.IllegalArgumentExceptions;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.entity.RepresentedEntity;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.mapper.RepresentedMapper;
import com.repconnect.api.infrastructure.repository.IRepresentedRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class RepresentedRepositoryGateway implements IRepresentedGateway {

    private final IRepresentedRepository iRepresentedRepository;
    private final PhoneRepositoryGateway phoneRepositoryGateway;


    public RepresentedRepositoryGateway(IRepresentedRepository iRepresentedRepository, PhoneRepositoryGateway phoneRepositoryGateway, PhoneEntityMapper phoneEntityMapper) {
        this.iRepresentedRepository = iRepresentedRepository;
        this.phoneRepositoryGateway = phoneRepositoryGateway;
    }

    @Override
    @Transactional
    public Represented createRepresented(Represented represented) {
        RepresentedEntity representedEntity = RepresentedMapper.INSTANCE.toRepresentedEntity(represented);
        if (representedEntity.getName() != null && iRepresentedRepository.existsByNameIgnoringSpaces(representedEntity.getName())) {
            throw new EntityAlreadyExistsException("An entity with this name already exists: " + representedEntity.getName());
        }
        try {
            RepresentedEntity savedRepresentedEntity = iRepresentedRepository.save(representedEntity);
            List<PhoneEntity> phoneEntityList = representedEntity.getPhones();
            if (phoneEntityList != null && !phoneEntityList.isEmpty()) {
                for (PhoneEntity phoneEntity : phoneEntityList) {
                    phoneEntity.setRepresented(savedRepresentedEntity);
                }
                phoneRepositoryGateway.saveAllPhoneList(phoneEntityList);
            }
            return RepresentedMapper.INSTANCE.toRepresented(savedRepresentedEntity);
        } catch (IllegalArgumentExceptions ex) {
            ex.printStackTrace();
            throw new IllegalArgumentExceptions("Error saving Represented");
        }

    }

    @Override
    public List<Represented> getAllRepresented() {
        List<RepresentedEntity> representedEntityList = iRepresentedRepository.findAll();
        return representedEntityList.stream()
                .map(RepresentedMapper.INSTANCE::toRepresented)
                .collect(Collectors.toList());
    }

    @Override
    public Represented updateRepresented(Represented represented) {
        if (represented == null || represented.id() == null) {
            throw new IllegalArgumentExceptions("The 'represented' parameter or its ID cannot be null.");
        }
        RepresentedEntity existingRepresentedEntity = iRepresentedRepository.findById(represented.id())
                .orElseThrow(() -> new EntityNotFoundExceptions("Entity not found"));
        updateEntityFields(existingRepresentedEntity, represented);
        RepresentedEntity updateRepresented = iRepresentedRepository.save(existingRepresentedEntity);
        return RepresentedMapper.INSTANCE.toRepresented(updateRepresented);
    }

    @Override
    public void deleteById(Integer id) {
        if(iRepresentedRepository.existsById(id)){
            iRepresentedRepository.deleteById(id);
        }else {
            throw new EntityNotFoundExceptions("Entity not found with ID: " + id);
        }


    }

    private void updateEntityFields(RepresentedEntity existingEntity, Represented newEntity) {
        existingEntity.setName(newEntity.name());
        existingEntity.setWebSite(newEntity.webSite());
        existingEntity.setEmail(newEntity.email());
        existingEntity.setAddress(newEntity.address());
        existingEntity.setPhones(newEntity.phones());
    }
}
