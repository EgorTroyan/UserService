package com.egortroyan.test.userService.service;

import com.egortroyan.test.userService.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUser(long id);
    void deleteUser(long id);
    void addUser(User user);

}
