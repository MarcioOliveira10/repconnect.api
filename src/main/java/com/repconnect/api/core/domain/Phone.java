package com.repconnect.api.core.domain;

import java.time.LocalDateTime;

public record Phone(
        Integer id,
        String phoneNumber,
        String name,
        Represented represented,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
