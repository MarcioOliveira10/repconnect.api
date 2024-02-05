package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.applicationn.useCase.user.CreateUserUseCase;
import com.repconnect.api.applicationn.useCase.user.UpdateUserUseCase;
import com.repconnect.api.infrastructure.gatewayImpl.UserRepositoryGateway;
import com.repconnect.api.infrastructure.repository.IUserRepository;
import com.repconnect.api.infrastructure.gatewayImpl.TypeOfUserDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    TypeOfUserDeserializer typeOfUserDeserializer(){
        return new TypeOfUserDeserializer();
    }
    @Bean
    UpdateUserUseCase updateUserUseCase(IUserGateway iUserGateway){
        return new UpdateUserUseCase(iUserGateway);
    }
    @Bean
    CreateUserUseCase createUserUseCase(IUserGateway iUserGateway){
        return new CreateUserUseCase(iUserGateway);
    }
    @Bean
    IUserGateway iUserGateway(IUserRepository iUserRepository){
        return new UserRepositoryGateway(iUserRepository);

    }
}
