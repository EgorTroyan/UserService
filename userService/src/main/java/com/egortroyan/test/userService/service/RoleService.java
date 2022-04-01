package com.egortroyan.test.userService.service;

import com.egortroyan.test.userService.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRole(long id);
    void addRole(Role role);
    void deleteRole(long id);

}
