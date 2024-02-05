package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.user.CreateUserUseCase;
import com.repconnect.api.applicationn.useCase.user.DeleteUserUseCase;
import com.repconnect.api.applicationn.useCase.user.UpdateUserUseCase;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.infrastructure.dto.user.UserDTOMapper;
import com.repconnect.api.infrastructure.dto.user.UserRequest;
import com.repconnect.api.infrastructure.dto.user.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

   public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
       this.updateUserUseCase = updateUserUseCase;
       this.deleteUserUseCase = deleteUserUseCase;
   }
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest){
        User userBusinessObj = UserDTOMapper.toUser(userRequest);
        User user = createUserUseCase.createUser(userBusinessObj);
        UserResponse userResponse = UserDTOMapper.toResponse(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest){
       User user = UserDTOMapper.toUser(userRequest);
       User userUpdated = updateUserUseCase.updateUser(user);
       UserResponse userResponse = UserDTOMapper.toResponse(userUpdated);
       return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Integer id){
       deleteUserUseCase.deleteUser(id);
       return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");


    }


}
