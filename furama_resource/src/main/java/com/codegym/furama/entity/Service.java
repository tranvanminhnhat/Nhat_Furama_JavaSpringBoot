package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
public class Service {
    @Id
    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{serviceId.empty}")
    @Pattern(regexp = "[D][V][0-9]{4}", message = "{serviceId.format}")
    private String serviceId;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{serviceName.empty}")
    private String serviceName;

    @Column(columnDefinition = "int")
    @NotNull(message = "{serviceArea.empty}")
    @Positive(message = "{serviceArea.value}")
    private Integer serviceArea;

    @Column(columnDefinition = "double")
    @NotNull(message = "{serviceCost.empty}")
    @Positive(message = "{serviceCost.value}")
    private Double serviceCost;

    @Column(columnDefinition = "int")
    @NotNull(message = "{serviceMaxPeople.empty}")
    @Positive(message = "{serviceMaxPeople.value}")
    private Integer serviceMaxPeople;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{standardRoom.empty}")
    private String standardRoom;

    @Column(columnDefinition = "varchar(45)")
    private String descriptionOtherConvenience;

    @Column(columnDefinition = "double")
    @Positive(message = "{poolArea.value}")
    private Double poolArea;

    @Column(columnDefinition = "int")
    @Positive(message = "{numberOfFloors.value}")
    private Integer numberOfFloors;

    @OneToMany(mappedBy = "service",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId",nullable = false,referencedColumnName = "serviceTypeId")
    @JsonBackReference
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId",nullable = false,referencedColumnName = "rentTypeId")
    @JsonBackReference
    private RentType rentType;

    public Service() {
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
