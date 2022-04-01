package com.egortroyan.test.userService.exception_handling;

public class UserServiceIncorrectData {

    private String info;

    public UserServiceIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
