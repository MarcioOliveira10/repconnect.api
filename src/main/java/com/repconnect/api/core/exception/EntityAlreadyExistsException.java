package com.repconnect.api.core.exception;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
