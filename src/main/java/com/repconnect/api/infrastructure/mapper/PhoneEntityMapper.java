package com.repconnect.api.infrastructure.mapper;

import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.entity.RepresentedEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneEntityMapper {
    public PhoneEntity toEntity(Phone phone) {
        return new PhoneEntity(
                phone.id(),
                phone.phoneNumber(),
                phone.name(),
                toRepresentedEntity(phone.represented()),
                phone.createdAt(),
                phone.updatedAt()
        );
    }
    public List<PhoneEntity> toEntityList(List<Phone> phones) {
        return phones.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public Phone toPhone(PhoneEntity phoneEntity) {
        return new Phone(
                phoneEntity.getId(),
                phoneEntity.getPhoneNumber(),
                phoneEntity.getName(),
                toRepresented(phoneEntity.getRepresented()),
                phoneEntity.getCreatedAt(),
                phoneEntity.getUpdateAt()
        );
    }

    private Represented toRepresented(RepresentedEntity representedEntity){
        if(representedEntity == null){
            return null;
        }
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

    private RepresentedEntity toRepresentedEntity(Represented represented){
        if(represented == null){
            return null;
        }
        return new RepresentedEntity(
                represented.id(),
                represented.name(),
                represented.webSite(),
                represented.email(),
                represented.address(),
                represented.phones(),
                represented.createdAt(),
                represented.updatedAt()
        );
    }
}
