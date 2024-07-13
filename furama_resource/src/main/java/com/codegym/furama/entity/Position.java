package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer positionId;

    private String positionName;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employees;

    public Position() {
    }

    public Position(Integer positionId, String name, Set<Employee> employees) {
        this.positionId = positionId;
        this.positionName = name;
        this.employees = employees;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String name) {
        this.positionName = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
