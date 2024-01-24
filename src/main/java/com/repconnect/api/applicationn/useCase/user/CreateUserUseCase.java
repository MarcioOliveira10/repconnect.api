package com.repconnect.api.applicationn.useCase.user;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.core.domain.User;

public class CreateUserUseCase {

    private final IUserGateway iUserGateway;

    public CreateUserUseCase(IUserGateway iUserGateway) {
        this.iUserGateway = iUserGateway;
    }

    public User createUser(User user){
        return iUserGateway.createUser(user);
    }
}
