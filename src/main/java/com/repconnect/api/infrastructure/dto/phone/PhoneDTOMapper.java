package com.repconnect.api.infrastructure.dto.phone;

import com.repconnect.api.core.domain.Phone;

public class PhoneDTOMapper {
    public CreatePhoneResponse toResponse(Phone phone){
        return new CreatePhoneResponse(
                phone.phoneNumber(),
                phone.name(),
                phone.createdAt());
    }

    public Phone toPhone(CreatePhoneRequest request){
        return new Phone(
                request.id(),
                request.phoneNumber(),
                request.name(),
                request.createdAt(),
                request.updatedAt()
                );
    }
}
