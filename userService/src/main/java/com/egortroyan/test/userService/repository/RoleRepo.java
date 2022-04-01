package com.egortroyan.test.userService.repository;

import com.egortroyan.test.userService.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
}
