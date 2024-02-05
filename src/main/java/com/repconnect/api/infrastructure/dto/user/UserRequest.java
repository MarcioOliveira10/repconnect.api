package com.repconnect.api.infrastructure.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.repconnect.api.core.domain.TypeOfUser;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.gatewayImpl.TypeOfUserDeserializer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record UserRequest(
        Integer id,
        String name,
        String email,
        PhoneEntity phone,
        AddressEntity address,
        @Enumerated(EnumType.STRING)
        @JsonProperty("TypeOfUser")
        @JsonDeserialize(using = TypeOfUserDeserializer.class)
        TypeOfUser typeOfUser,
        String password,
        String activationKey,
        String rememberToken,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
