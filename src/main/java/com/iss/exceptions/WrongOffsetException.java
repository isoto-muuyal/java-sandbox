package com.iss.exceptions;

public class WrongOffsetException extends RuntimeException{

    public WrongOffsetException(String message) {
        super("WOE: " + message);
    }

}
