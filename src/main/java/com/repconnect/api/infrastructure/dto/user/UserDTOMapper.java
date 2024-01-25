package com.repconnect.api.infrastructure.dto.user;

import com.repconnect.api.core.domain.Address;
import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.entity.PhoneEntity;


public class UserDTOMapper {

    public static User toUser(UserRequest userRequest) {
        return new User(
                userRequest.id(),
                userRequest.name(),
                userRequest.email(),
                mapPhoneEntityToPhone(userRequest.phone()),
                mapAddressEntityToAddress(userRequest.address()),
                userRequest.typeOfUser(),
                userRequest.password(),
                userRequest.activationKey(),
                userRequest.rememberToken(),
                userRequest.createdAt(),
                userRequest.updatedAt()
        );
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.id(),
                user.name(),
                user.email(),
                mapPhoneToPhoneEntity(user.phone()),
                mapAddressToAddressEntity(user.address()),
                user.typeOfUser(),
                user.password(),
                user.activationKey(),
                user.rememberToken(),
                user.createdAt(),
                user.updatedAt()

        );
    }




    private static Phone mapPhoneEntityToPhone(PhoneEntity phoneEntity) {
        if (phoneEntity == null) {
            return null;
        }
        return new Phone(
                phoneEntity.getId(),
                phoneEntity.getPhoneNumber(),
                phoneEntity.getName(),
                null,
                phoneEntity.getCreatedAt(),
                phoneEntity.getUpdatedAt()
        );
    }

    private static PhoneEntity mapPhoneToPhoneEntity(Phone phone){
        if(phone == null){
            return null;
        }
        return new PhoneEntity(
                phone.id(),
                phone.phoneNumber(),
                phone.name(),
                null,
                phone.createdAt(),
                null
        );

    }

    private static Address mapAddressEntityToAddress(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        return new Address(
                addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getCity(),
                addressEntity.getZipCode(),
                addressEntity.getComplement(),
                null,
                null
        );
    }
    private static AddressEntity mapAddressToAddressEntity(Address address){
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
