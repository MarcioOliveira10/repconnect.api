package com.repconnect.api.infrastructure.config;


import com.repconnect.api.infrastructure.dto.converters.TypeOfUserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TypeOfUserConverterConfig {

    @Bean
    public TypeOfUserConverter typeOfUserConverter(){
        return new TypeOfUserConverter();
    }

}
