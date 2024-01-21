package com.repconnect.api.core.domain;

import java.time.LocalDateTime;

public record Seller(
        Integer id,
        User user,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
