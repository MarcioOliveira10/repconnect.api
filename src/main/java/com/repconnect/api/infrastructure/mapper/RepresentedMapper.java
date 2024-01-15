package com.repconnect.api.infrastructure.mapper;

import com.repconnect.api.core.domain.Represented;
import com.repconnect.api.infrastructure.entity.RepresentedEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class RepresentedMapper {
    public static final RepresentedMapper INSTANCE = Mappers.getMapper(RepresentedMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract RepresentedEntity toRepresentedEntity(Represented represented);
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract Represented toRepresented(RepresentedEntity representedEntity);
}
