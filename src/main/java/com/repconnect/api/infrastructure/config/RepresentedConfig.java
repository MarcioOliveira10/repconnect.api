package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IRepresentedGateway;
import com.repconnect.api.applicationn.useCase.represented.CreateRepresentedUseCase;
import com.repconnect.api.applicationn.useCase.represented.GetAllRepresentedUseCase;
import com.repconnect.api.infrastructure.controllers.RepresentedController;
import com.repconnect.api.infrastructure.dto.represented.RepresentedDTOMapper;
import com.repconnect.api.infrastructure.entity.AddressEntity;
import com.repconnect.api.infrastructure.gatewayImpl.PhoneRepositoryGateway;
import com.repconnect.api.infrastructure.gatewayImpl.RepresentedRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.PhoneEntityMapper;
import com.repconnect.api.infrastructure.mapper.RepresentedEntityMapper;
import com.repconnect.api.infrastructure.repository.IRepresentedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepresentedConfig {

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
            RepresentedEntityMapper representedEntityMapper,
            PhoneRepositoryGateway phoneRepositoryGateway,
            PhoneEntityMapper phoneEntityMapper){
        return new RepresentedRepositoryGateway(iRepresentedRepository,representedEntityMapper, phoneRepositoryGateway, phoneEntityMapper);
    }
    @Bean
    RepresentedEntityMapper representedEntityMapper(ModelMapper modelMapper){return new RepresentedEntityMapper(modelMapper);}
    @Bean
   RepresentedDTOMapper representedDTOMapper(){return new RepresentedDTOMapper();}
}
