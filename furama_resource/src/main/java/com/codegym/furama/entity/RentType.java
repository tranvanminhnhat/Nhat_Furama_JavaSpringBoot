package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rentTypeId;

    private String rentTypeName;

    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Service> services;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
