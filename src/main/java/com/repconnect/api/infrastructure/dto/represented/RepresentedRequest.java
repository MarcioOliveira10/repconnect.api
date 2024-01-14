package com.repconnect.api.infrastructure.dto.represented;

import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.entity.PhoneEntity;

import java.time.LocalDateTime;
import java.util.List;

public record RepresentedRequest(
        Integer id,
        String name,
        String webSite,
        String email,
        AddressEntity address,
        List<PhoneEntity> phones,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
