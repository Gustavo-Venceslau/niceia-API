package com.galmv.chat.exceptions;

import java.io.Serial;

public class ChatNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ChatNotFoundException(String message){
        super(message);
    }
}
