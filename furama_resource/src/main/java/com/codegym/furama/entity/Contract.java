package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int")
    private Integer contractId;

    @Column(columnDefinition = "date")
    @NotNull(message = "{contractStartDate.empty}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractStartDate;

    @Column(columnDefinition = "date")
    @NotNull(message = "{contractEndDate.empty}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contractEndDate;

    @Column(columnDefinition = "double")
    @NotNull(message = "{contractDeposit.empty}")
    @Positive(message = "{contractDeposit.value}")
    private Double contractDeposit;

    @Column(columnDefinition = "double")
    @NotNull(message = "{contractTotalMoney.empty}")
    @Positive(message = "{contractTotalMoney.value}")
    private Double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employeeId",nullable = false,referencedColumnName = "employeeId")
    @JsonBackReference
    private Employee employee;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn(name = "serviceId",nullable = false,referencedColumnName = "serviceId")
    @JsonBackReference
    private Service service;

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false,referencedColumnName = "customerId")
    @JsonBackReference
    private Customer customer;

    public Contract() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
