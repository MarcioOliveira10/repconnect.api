package com.repconnect.api.infrastructure.dto.phone;

import java.time.LocalDateTime;

public record PhoneResponse(
        String phoneNumber,
        String name,
        LocalDateTime createdAt
) {
}
