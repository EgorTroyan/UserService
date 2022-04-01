package com.egortroyan.test.userService.exception_handling;

public class NoSuchRoleException extends RuntimeException{

    public NoSuchRoleException(String info){
        super(info);
    }
}
