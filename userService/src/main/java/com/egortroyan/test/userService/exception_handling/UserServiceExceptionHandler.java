package com.egortroyan.test.userService.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserServiceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserServiceIncorrectData> handleException (NoSuchUserException exception){
        UserServiceIncorrectData userServiceIncorrectData = new UserServiceIncorrectData(exception.getMessage());
        return new ResponseEntity<>(userServiceIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserServiceIncorrectData> handleException (NoSuchRoleException exception){
        UserServiceIncorrectData userServiceIncorrectData = new UserServiceIncorrectData(exception.getMessage());
        return new ResponseEntity<>(userServiceIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserServiceIncorrectData> handleException (Exception exception){
        UserServiceIncorrectData userServiceIncorrectData = new UserServiceIncorrectData(exception.getMessage());
        return new ResponseEntity<>(userServiceIncorrectData, HttpStatus.BAD_REQUEST);
    }
}
