package com.egortroyan.test.userService.controller;

import com.egortroyan.test.userService.entity.Role;
import com.egortroyan.test.userService.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleServiceController {

    private final RoleService roleService;

    public RoleServiceController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> showAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/roles/{id}")
    public Role getRole(@PathVariable int id) {
        return roleService.getRole(id);
    }

    @PostMapping("/roles")
    public Role addNewRole(@RequestBody Role role) {
        roleService.addRole(role);
        return role;
    }

    @PutMapping("/roles")
    public Role updateRole(@RequestBody Role role) {
        roleService.addRole(role);
        return role;
    }

    @DeleteMapping("/roles/{id}")
    public String deleteRole(@PathVariable int id){
        roleService.deleteRole(id);
        return "Role with id = " + id + " was deleted, also was deleted all Users with that Role";
    }
}
