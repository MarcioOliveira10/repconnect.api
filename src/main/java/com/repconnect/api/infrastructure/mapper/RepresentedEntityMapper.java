package com.repconnect.api.infrastructure.mapper;

import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.infrastructure.entity.RepresentedEntity;

public class RepresentedEntityMapper {

    public RepresentedEntity toRepresentedEntity(Represented represented){
        return new RepresentedEntity(
                represented.id(),
                represented.name(),
                represented.webSite(),
                represented.email(),
                represented.address(),
                represented.phones(),
                represented.updatedAt(),
                represented.createdAt());
    }

    public Represented toRepresented(RepresentedEntity representedEntity){
        return new Represented(
                representedEntity.getId(),
                representedEntity.getName(),
                representedEntity.getWebSite(),
                representedEntity.getEmail(),
                representedEntity.getAddress(),
                representedEntity.getPhones(),
                representedEntity.getCreatedAt(),
                representedEntity.getUpdatedAt());
    }
}
