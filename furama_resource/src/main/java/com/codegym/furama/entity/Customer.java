package com.codegym.furama.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer{
    @Id
    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{customerId.empty}")
    @Pattern(regexp = "^[K][H][0-9]{4}+$", message = "{customerId.format}")
    private String customerId;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{customerName.empty}")
    private String customerName;

    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{customerBirthday.empty}")
    private Date customerBirthday;

    @Column(columnDefinition = "bit")
    private Integer customerGender;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{customerIdCard.empty}")
    @Pattern(regexp = "^[0-9]{9}+$", message = "{customerIdCard.format}")
    private String customerIdCard;

    @Column(columnDefinition = "varchar(45)")
    @NotBlank(message = "{customerPhone.empty}")
    @Pattern(regexp = "^[0][9][01][0-9]{7}+$", message = "{customerPhone.format}")
    private String customerPhone;

    private String customerEmail;

    private String customerAddress;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "customerTypeId",nullable = false,referencedColumnName = "customerTypeId")
    @JsonBackReference
    private CustomerType customerType;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
