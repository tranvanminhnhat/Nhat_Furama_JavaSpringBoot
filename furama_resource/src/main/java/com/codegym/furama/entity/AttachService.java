package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer attachServiceId;

    private String attachServiceName;

    private Double attachServiceCost;

    private Integer attachServiceUnit;

    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;

    public AttachService() {
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
