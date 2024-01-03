package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IInvoiceDataGateway;
import com.repconnect.api.applicationn.gateway.IPhoneGateway;
import com.repconnect.api.applicationn.useCase.CreatePhoneUseCase;
import com.repconnect.api.applicationn.useCase.GetAllPhonesUseCase;
import com.repconnect.api.applicationn.useCase.UpdateInvoiceDataUseCase;
import com.repconnect.api.infrastructure.dto.phone.PhoneDTOMapper;
import com.repconnect.api.infrastructure.gatewayImpl.PhoneRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.repository.IPhoneRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneConfig {


    @Bean
    GetAllPhonesUseCase getAllPhonesUseCase(IPhoneGateway iPhoneGateway){
        return new GetAllPhonesUseCase(iPhoneGateway);
    }
    @Bean
    CreatePhoneUseCase createPhoneUseCase(IPhoneGateway iPhoneGateway) {
        return new CreatePhoneUseCase(iPhoneGateway);
    }

    @Bean
    IPhoneGateway iPhoneGateway(IPhoneRepository iPhoneRepository, PhoneEntityMapper phoneEntityMapper) {
        return new PhoneRepositoryGateway(iPhoneRepository, phoneEntityMapper);
    }

    @Bean
    PhoneEntityMapper phoneEntityMapper() {
        return new PhoneEntityMapper();
    }

    @Bean
    PhoneDTOMapper phoneDTOMapper() {
        return new PhoneDTOMapper();
    }
}
