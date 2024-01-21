package com.repconnect.api.core.domain;

import java.time.LocalDateTime;

public record User(
        Integer id,
        String name,
        String email,
        Phone phone,
        Address address,
        TypeOfUser typeOfUser,
        String password,
        String activationKey,
        String rememberToken,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
