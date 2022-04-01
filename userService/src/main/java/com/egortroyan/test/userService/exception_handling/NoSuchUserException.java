package com.egortroyan.test.userService.exception_handling;

public class NoSuchUserException extends RuntimeException{

    public NoSuchUserException(String info){
        super(info);
    }
}
