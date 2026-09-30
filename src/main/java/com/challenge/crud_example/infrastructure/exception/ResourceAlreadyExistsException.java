package com.challenge.crud_example.infrastructure.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }
}
