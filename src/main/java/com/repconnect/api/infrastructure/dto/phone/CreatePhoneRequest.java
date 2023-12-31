package com.repconnect.api.infrastructure.dto.phone;

import java.time.LocalDateTime;

public record CreatePhoneRequest(
        Integer id,
        String phoneNumber,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
