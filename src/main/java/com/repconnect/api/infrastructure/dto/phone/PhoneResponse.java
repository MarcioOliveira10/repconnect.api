package com.repconnect.api.infrastructure.dto.phone;

import com.repconnect.api.core.domain.Represented;

import java.time.LocalDateTime;

public record PhoneResponse(
        String phoneNumber,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
