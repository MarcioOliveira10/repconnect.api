package com.repconnect.api.infrastructure.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.repconnect.api.core.domain.TypeOfUser;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.entity.PhoneEntity;

import java.time.LocalDateTime;

public record UserRequest(
        Integer id,
        String name,
        String email,
        PhoneEntity phone,
        AddressEntity address,
        @JsonProperty("TypeOfUser")
        TypeOfUser typeOfUser,
        String password,
        String activationKey,
        String rememberToken,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
