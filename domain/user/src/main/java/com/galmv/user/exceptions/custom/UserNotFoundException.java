package com.galmv.user.exceptions.custom;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException{

    @Serial
    private final static long serialVersionUID = 1L;
    public UserNotFoundException(String message){
        super(message);
    }
}
