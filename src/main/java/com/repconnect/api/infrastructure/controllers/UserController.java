package com.repconnect.api.infrastructure.controllers;

import com.repconnect.api.applicationn.useCase.user.CreateUserUseCase;
import com.repconnect.api.core.domain.User;
import com.repconnect.api.infrastructure.dto.user.UserDTOMapper;
import com.repconnect.api.infrastructure.dto.user.UserRequest;
import com.repconnect.api.infrastructure.dto.user.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

   public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest){
        User userBusinessObj = UserDTOMapper.toUser(userRequest);
        User user = createUserUseCase.createUser(userBusinessObj);
        UserResponse userResponse = UserDTOMapper.toResponse(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


}
