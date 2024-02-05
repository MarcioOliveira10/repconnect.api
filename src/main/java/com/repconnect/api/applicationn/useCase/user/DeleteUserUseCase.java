package com.repconnect.api.applicationn.useCase.user;

import com.repconnect.api.applicationn.gateway.IUserGateway;

public class DeleteUserUseCase {

    public final IUserGateway iUserGateway;


    public DeleteUserUseCase(IUserGateway iUserGateway) {
        this.iUserGateway = iUserGateway;
    }

    public void deleteUser(Integer id){
        iUserGateway.deleteById(id);
    }
}
