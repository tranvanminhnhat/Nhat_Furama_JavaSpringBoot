package com.codegym.furama.repository;

import com.codegym.furama.entity.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
    @Query("select ur.role.roleName from UserRole ur where ur.user.username = :username")
    List<String> findAllRoleByUser(String username);
}
