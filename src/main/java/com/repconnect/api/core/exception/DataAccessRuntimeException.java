package com.repconnect.api.core.exception;

public class DataAccessRuntimeException extends RuntimeException{

    public DataAccessRuntimeException(String message, DataAccessRuntimeException ex){
        super(message);
    }
}
