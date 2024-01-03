package com.repconnect.api.infrastructure.dto.phone;

import java.time.LocalDateTime;

public record PhoneRequest(
        Integer id,
        String phoneNumber,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
