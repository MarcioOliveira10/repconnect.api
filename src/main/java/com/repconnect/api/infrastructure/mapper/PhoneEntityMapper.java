package com.repconnect.api.infrastructure.mapper;

import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.infrastructure.entity.PhoneEntity;

public class PhoneEntityMapper {
    public PhoneEntity toEntity(Phone phone) {
        return new PhoneEntity(
                phone.id(),
                phone.phoneNumber(),
                phone.name(),
                phone.createdAt(),
                phone.updatedAt()
        );
    }

    public Phone toPhone(PhoneEntity phoneEntity) {
        return new Phone(
                phoneEntity.getId(),
                phoneEntity.getPhoneNumber(),
                phoneEntity.getName(),
                phoneEntity.getCreatedAt(),
                phoneEntity.getUpdateAt()
        );
    }
}
