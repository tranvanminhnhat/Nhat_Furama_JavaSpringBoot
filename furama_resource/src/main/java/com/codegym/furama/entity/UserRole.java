package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
    @Id
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false,referencedColumnName = "userId")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "roleId",nullable = false,referencedColumnName = "roleId")
    @JsonBackReference
    private Role role;

    public UserRole() {
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
