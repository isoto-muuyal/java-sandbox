package com.iss.citiExample.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("user not found: ");
    }

    public NotFoundException(String message){
        super("not found: " + message);
    }
}
