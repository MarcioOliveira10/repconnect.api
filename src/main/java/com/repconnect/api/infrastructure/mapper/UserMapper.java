package com.repconnect.api.infrastructure.mapper;


import com.repconnect.api.core.domain.Phone;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.infrastructure.entity.PhoneEntity;
import com.repconnect.api.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "phone", qualifiedByName = "mapPhoneToPhoneEntity")
    public abstract UserEntity toUserEntity(User user);

    public abstract User toUser(UserEntity userEntity);

     @Named("mapPhoneToPhoneEntity")
     protected abstract PhoneEntity mapPhoneToPhoneEntity(Phone phone);
}
