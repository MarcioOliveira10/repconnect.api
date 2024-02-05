package com.repconnect.api.infrastructure.config;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.applicationn.useCase.user.CreateUserUseCase;
import com.repconnect.api.applicationn.useCase.user.DeleteUserUseCase;
import com.repconnect.api.applicationn.useCase.user.GetAllUserUseCase;
import com.repconnect.api.applicationn.useCase.user.UpdateUserUseCase;
import com.repconnect.api.infrastructure.gatewayImpl.UserRepositoryGateway;
import com.repconnect.api.infrastructure.mapper.UserMapper;
import com.repconnect.api.infrastructure.repository.IUserRepository;
import com.repconnect.api.infrastructure.gatewayImpl.TypeOfUserDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    GetAllUserUseCase getAllUserUseCase(IUserGateway iUserGateway){
        return new GetAllUserUseCase(iUserGateway);
    }
    @Bean
    DeleteUserUseCase deleteUserUseCase(IUserGateway iUserGateway){
        return new DeleteUserUseCase(iUserGateway);
    }
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
    IUserGateway iUserGateway(IUserRepository iUserRepository, UserMapper userMapper){
        return new UserRepositoryGateway(iUserRepository, userMapper);

    }
}
