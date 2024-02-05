package com.repconnect.api.applicationn.gateway;

import com.repconnect.api.core.domain.User;

import java.util.List;

public interface IUserGateway {

    User createUser(User user);

    User updateUser(User user);

    void deleteById(Integer id);

    List<User> getAllUser();
}
