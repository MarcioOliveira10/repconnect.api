package com.repconnect.api.infrastructure.dto.represented;

import com.repconnect.api.core.domain.Represented;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class RepresentedDTOMapper {

    public static final RepresentedDTOMapper INSTANCE = Mappers.getMapper(RepresentedDTOMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract RepresentedResponse toResponse(Represented represented);
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract  Represented toRepresented(RepresentedRequest request);

}
