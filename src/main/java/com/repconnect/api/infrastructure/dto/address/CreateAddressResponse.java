package com.repconnect.api.infrastructure.dto.address;

import java.time.LocalDateTime;

public record CreateAddressResponse(

        String street,
        String number,
        String city,
        String zipCode,
        String complement,
        LocalDateTime createdAt
) {
}
