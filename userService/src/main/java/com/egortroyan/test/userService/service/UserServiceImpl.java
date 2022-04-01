package com.egortroyan.test.userService.service;

import com.egortroyan.test.userService.entity.Role;
import com.egortroyan.test.userService.entity.User;
import com.egortroyan.test.userService.exception_handling.NoSuchRoleException;
import com.egortroyan.test.userService.exception_handling.NoSuchUserException;
import com.egortroyan.test.userService.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleService roleService;

    public UserServiceImpl(UserRepo userRepo, RoleService roleService) {
        this.userRepo = userRepo;
        this.roleService = roleService;
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> usersOp = userRepo.findAll();
        List<User> users = new ArrayList<>();
        for(User u : usersOp){
         users.add(u);
        }
        return users;
    }

    @Override
    public User getUser(long id) throws NoSuchUserException {
        Optional<User> opUser = userRepo.findById(id);
        User user = opUser.orElse(null);
        if(user == null){
            throw new NoSuchUserException("User with id = " + id + " not found.");
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        if(getUser(id) == null){
            throw new NoSuchUserException("User with id = " + id + " not found.");
        }
        userRepo.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        Role role = roleService.getRole(user.getRole().getId());
        if(role == null){
            throw new NoSuchRoleException("Can't add or update User with id = " + user.getId() + ". Role with id = " + user.getRole().getId() + " not found.");
        }
        if (user.getId() != 0) {
            if (getUser(user.getId()) == null) {
                throw new NoSuchUserException("User with id = " + user.getId() + " not found.");
            }
        }
        user.setRole(role);
        userRepo.save(user);
    }
}
