package com.repconnect.api.core.exception;

public class InvoiceUniqueViolationException extends RuntimeException{
    public InvoiceUniqueViolationException(String message){
        super(message);
    }
}
