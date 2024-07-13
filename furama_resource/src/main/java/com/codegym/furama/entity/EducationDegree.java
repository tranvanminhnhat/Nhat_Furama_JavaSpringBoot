package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer educationDegreeId;

    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
