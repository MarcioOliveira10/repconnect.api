package com.repconnect.api.infrastructure.dto.phone;

import com.repconnect.api.core.domain.Phone;

public class PhoneDTOMapper {
    public PhoneResponse toResponse(Phone phone){
        return new PhoneResponse(
                phone.phoneNumber(),
                phone.name(),
                phone.createdAt());
    }

    public Phone toPhone(PhoneRequest request){
        return new Phone(
                request.id(),
                request.phoneNumber(),
                request.name(),
                request.represented(),
                request.createdAt(),
                request.updatedAt()
                );
    }
}
