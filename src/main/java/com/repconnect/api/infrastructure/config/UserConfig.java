package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.applicationn.useCase.user.CreateUserUseCase;
import com.repconnect.api.infrastructure.gatewayImpl.UserRepositoryGateway;
import com.repconnect.api.infrastructure.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {


    @Bean
    CreateUserUseCase createUserUseCase(IUserGateway iUserGateway){
        return new CreateUserUseCase(iUserGateway);
    }
    @Bean
    IUserGateway iUserGateway(IUserRepository iUserRepository){
        return new UserRepositoryGateway(iUserRepository);

    }
}
