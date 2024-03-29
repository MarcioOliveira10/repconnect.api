package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.applicationn.useCase.represented.CreateRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.DeleteRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.GetAllRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.UpdateRepresentedUseCase;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.gatewayImpl.PhoneRepositoryGateway;
import com.repconnect.api.infrastructure.gatewayImpl.RepresentedRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.repository.IRepresentedRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepresentedConfig {
    @Bean
    DeleteRepresentedUseCase deleteRepresentedUseCase(IRepresentedGateway iRepresentedGateway){
        return new DeleteRepresentedUseCase(iRepresentedGateway);
    }
    @Bean
    UpdateRepresentedUseCase updateRepresentedUseCase(IRepresentedGateway iRepresentedGateway){
        return new UpdateRepresentedUseCase(iRepresentedGateway);
    }

    @Bean
    GetAllRepresentedUseCase getAllRepresentedUseCase(IRepresentedGateway iRepresentedGateway){
        return new GetAllRepresentedUseCase(iRepresentedGateway);
    }
    @Bean
    CreateRepresentedUseCase createRepresentedUseCase(IRepresentedGateway iRepresentedGateway){
        return new CreateRepresentedUseCase(iRepresentedGateway);
    }
    @Bean
    AddressEntity addressEntity(){return new AddressEntity();}
    @Bean
    IRepresentedGateway iRepresentedGateway(
            IRepresentedRepository iRepresentedRepository,
            PhoneRepositoryGateway phoneRepositoryGateway,
            PhoneEntityMapper phoneEntityMapper){
        return new RepresentedRepositoryGateway(iRepresentedRepository,phoneRepositoryGateway, phoneEntityMapper);
    }
}
