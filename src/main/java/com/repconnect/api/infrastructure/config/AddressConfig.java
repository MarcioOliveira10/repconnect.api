package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IAddressGateway;
import com.repconnect.api.applicationn.useCase.CreateAddressUseCase;
import com.repconnect.api.infrastructure.dto.address.AddressDTOMapper;
import com.repconnect.api.infrastructure.gatewayImpl.AddressRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.AddressEntityMapper;
import com.repconnect.api.infrastructure.repository.IAddressRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressConfig {
    @Bean
    CreateAddressUseCase createAddressUseCase(IAddressGateway IAddressGateway) {
        return new CreateAddressUseCase(IAddressGateway);
    }

    @Bean
    IAddressGateway addressGateway(IAddressRepository iAddressRepository, AddressEntityMapper addressEntityMapper) {
        return new AddressRepositoryGateway(iAddressRepository, addressEntityMapper);
    }

    @Bean
    AddressEntityMapper addressEntityMapper() {
        return new AddressEntityMapper();
    }

    @Bean
    AddressDTOMapper addressDTOMapper() {
        return new AddressDTOMapper();
    }
}
