package com.repconnect.api.infrastructure.dto.user;

import com.repconnect.api.core.domain.TypeOfUser;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.entity.PhoneEntity;

public record UserRequest(
        String name,
        String email,
        PhoneEntity phone,
        AddressEntity address,
        TypeOfUser typeOfUser,
        String password,
        String activationKey,
        String rememberToken
) {
}
