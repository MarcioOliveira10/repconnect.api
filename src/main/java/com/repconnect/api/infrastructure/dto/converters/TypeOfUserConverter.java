package com.repconnect.api.infrastructure.dto.converters;

import com.repconnect.api.core.domain.TypeOfUser;
import com.repconnect.api.core.exception.IllegalArgumentExceptions;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;
@Converter(autoApply = true)
public class TypeOfUserConverter implements AttributeConverter <TypeOfUser, String>{
    @Override
    public String convertToDatabaseColumn(TypeOfUser typeOfUser) {
        if (typeOfUser == null){
            return null;
        }
        return typeOfUser.getValue();
    }

    @Override
    public TypeOfUser convertToEntityAttribute(String value) {
        if(value == null){
            return null;
        }
        return Stream.of(TypeOfUser.values())
                .filter(t -> t.getValue()
                        .equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentExceptions("Invalid TypeOfUser value: " + value));
    }
}
