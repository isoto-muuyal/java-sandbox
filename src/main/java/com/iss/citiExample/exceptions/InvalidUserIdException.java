package com.iss.citiExample.exceptions;

public class InvalidUserIdException extends RuntimeException {

    public InvalidUserIdException(){
        super("invalid user");
    }

    public InvalidUserIdException(String message) {
        super("invalid user: " + message);
    }
}
