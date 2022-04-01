package com.egortroyan.test.userService.service;

import com.egortroyan.test.userService.entity.Role;
import com.egortroyan.test.userService.exception_handling.NoSuchRoleException;
import com.egortroyan.test.userService.repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> getAllRoles() {
        Iterable<Role> rolesOp = roleRepo.findAll();
        List<Role> roles = new ArrayList<>();
        for(Role r : rolesOp){
            roles.add(r);
        }
        return roles;
    }

    @Override
    public Role getRole(long id) {
        Optional<Role> opRole = roleRepo.findById(id);
        Role role = opRole.orElse(null);
        if(role == null) {
            throw new NoSuchRoleException("Role with id = " + id + " not found.");
        }
        return role;
    }

    @Override
    public void addRole(Role role) {
        if (role.getId() != 0) {
            if (getRole(role.getId()) == null) {
                throw new NoSuchRoleException("Role with id = " + role.getId() + " not found.");
            }
        }
        roleRepo.save(role);
    }

    @Override
    public void deleteRole(long id) {
        if(getRole(id) == null){
            throw new NoSuchRoleException("Role with id = " + id + " not found.");
        }
        roleRepo.deleteById(id);
    }
}
