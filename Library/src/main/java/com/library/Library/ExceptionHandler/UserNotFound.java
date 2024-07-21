package com.library.Library.ExceptionHandler;

public class UserNotFound extends  RuntimeException{
    public UserNotFound(String message){
        super(message);
    }
}
