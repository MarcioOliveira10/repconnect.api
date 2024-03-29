package com.repconnect.api.infrastructure.gatewayImpl;

import com.repconnect.api.applicationn.gateway.IUserGateway;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.core.exception.DataAccessRuntimeException;
import com.repconnect.api.core.exception.EntityNotFoundExceptions;
import com.repconnect.api.core.exception.IllegalArgumentExceptions;
import com.repconnect.api.infrastructure.entity.UserEntity;
import com.repconnect.api.infrastructure.mapper.UserMapper;
import com.repconnect.api.infrastructure.repository.IUserRepository;

import java.util.List;
import java.util.stream.Collectors;

import static com.repconnect.api.infrastructure.util.UserUtil.updateEntityFields;

public class UserRepositoryGateway implements IUserGateway {

    private final IUserRepository iUserRepository;
    private final UserMapper userMapper;

    public UserRepositoryGateway(IUserRepository iUserRepository, UserMapper userMapper) {
        this.iUserRepository = iUserRepository;
        this.userMapper = userMapper;
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

    @Override
    public User updateUser(User user) {
      if(user == null || user.id() == null){
          throw new IllegalArgumentExceptions("The 'User' parameter or its ID cannot be null.");
      }
      UserEntity existingUserEntity = iUserRepository.findById(user.id())
                      .orElseThrow(() -> new EntityNotFoundExceptions("Entity not found with ID:" + user.id()));
      updateEntityFields(existingUserEntity, user);
      UserEntity updateUser = iUserRepository.save(existingUserEntity);
      return UserMapper.INSTANCE.toUser(updateUser);
    }

    @Override
    public void deleteById(Integer id) {
        if(iUserRepository.existsById(id)){
            iUserRepository.deleteById(id);
        }else {
            throw new EntityNotFoundExceptions("Entity not found with ID: " + id);
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            List<UserEntity> userEntityList = iUserRepository.findAll();
            return userEntityList.stream()
                    .map(userMapper.INSTANCE::toUser)
                    .collect(Collectors.toList());
        }catch (DataAccessRuntimeException ex){
            ex.printStackTrace();
            throw new DataAccessRuntimeException("Error accessing data", ex);
        }

    }


}
