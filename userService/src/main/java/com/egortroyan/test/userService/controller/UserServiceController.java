package com.egortroyan.test.userService.controller;

import com.egortroyan.test.userService.entity.User;
import com.egortroyan.test.userService.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserServiceController {

    private final UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "User with id = " + id + " was deleted";
    }
}
