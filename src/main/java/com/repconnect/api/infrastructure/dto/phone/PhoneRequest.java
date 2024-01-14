package com.repconnect.api.infrastructure.dto.phone;

import com.repconnect.api.core.domain.Represented;

import java.time.LocalDateTime;

public record PhoneRequest(
        Integer id,
        String phoneNumber,
        String name,
        Represented represented,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
