package com.repconnect.api.applicationn.useCase.user;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.core.domain.User;

public class UpdateUserUseCase {

    private final IUserGateway iUserGateway;

    public UpdateUserUseCase(IUserGateway iUserGateway) {
        this.iUserGateway = iUserGateway;
    }

    public User updateUser(User user){
        return iUserGateway.updateUser(user);
    }
}
