package com.ecotrack.citizenship.exception;
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){

        super(message);
    }
}