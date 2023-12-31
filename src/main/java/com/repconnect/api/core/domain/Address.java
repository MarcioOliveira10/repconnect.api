package com.repconnect.api.core.domain;

import java.time.LocalDateTime;

public record Address(
        Integer id,
        String street,
        String number,
        String city,
        String zipCode,
        String complement,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
