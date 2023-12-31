package com.repconnect.api.infrastructure.dto.address;

import java.time.LocalDateTime;

public record CreateAddressRequest(
        Integer id,
        String street,
        String number,
        String city,
        String zipCode,
        String complement,
        LocalDateTime createAt,
        LocalDateTime updatedAt) {
}
