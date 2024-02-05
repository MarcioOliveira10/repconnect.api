package com.repconnect.api.applicationn.useCase.user;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.core.domain.User;

import java.util.List;

public class GetAllUserUseCase {
    private final IUserGateway iUserGateway;

    public GetAllUserUseCase(IUserGateway iUserGateway) {
        this.iUserGateway = iUserGateway;
    }

    public List<User> getAllUser(){
        return iUserGateway.getAllUser();
    }
}
