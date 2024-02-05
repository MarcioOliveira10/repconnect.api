package com.repconnect.api.infrastructure.util;

import com.repconnect.api.core.domain.Address;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.entity.UserEntity;

public class UserUtil {

    public static void updateEntityFields(UserEntity existingUserEntity, User newUser){
        existingUserEntity.setEmail(newUser.email());
        existingUserEntity.setName(newUser.name());
        existingUserEntity.setPhone(toPhoneEntity(newUser.phone()));
        existingUserEntity.setAddress(toAddressEntity(newUser.address()));
        existingUserEntity.setTypeOfUser(newUser.typeOfUser());
        existingUserEntity.setPassword(newUser.password());
        existingUserEntity.setActivationKey(newUser.activationKey());
        existingUserEntity.setRememberToken(newUser.rememberToken());
        existingUserEntity.setCreatedAt(newUser.createdAt());
    }

    public static PhoneEntity toPhoneEntity(Phone phone) {
        if (phone == null){
            return null;
        }
        return new PhoneEntity(
                phone.id(),
                phone.phoneNumber(),
                phone.name(),
                null,
                phone.createdAt(),
                phone.updatedAt()
        );
    }

    public static AddressEntity toAddressEntity(Address address){
        if(address == null){
            return null;
        }
        return new AddressEntity(
                address.id(),
                address.street(),
                address.number(),
                address.city(),
                address.zipCode(),
                address.complement(),
                address.createdAt(),
                address.updatedAt()
        );
    }


}
