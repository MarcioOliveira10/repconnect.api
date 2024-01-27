package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.core.exception.IllegalArgumentExceptions;
import com.repconnect.api.infrastructure.entity.UserEntity;
import com.repconnect.api.infrastructure.mapper.UserMapper;
import com.repconnect.api.infrastructure.repository.IUserRepository;

public class UserRepositoryGateway implements IUserGateway {

    private final IUserRepository iUserRepository;

    public UserRepositoryGateway(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public User createUser(User user) {
        if(iUserRepository.existsByNameOrEmail(user.name(),user.email())){
            throw new IllegalArgumentExceptions(("User with the same name or email already exists"));
        }
        UserEntity userEntity = UserMapper.INSTANCE.toUserEntity(user);
        try {
            UserEntity savedUserEntity = iUserRepository.save(userEntity);
            return UserMapper.INSTANCE.toUser(savedUserEntity);
        }catch (IllegalArgumentExceptions ex){
            ex.printStackTrace();
            throw new IllegalArgumentExceptions("Error saving User");
        }
    }
}
