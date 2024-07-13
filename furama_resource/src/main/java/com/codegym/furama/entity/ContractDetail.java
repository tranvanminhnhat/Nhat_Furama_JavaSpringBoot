package com.codegym.furama.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractDetailId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "contractId",nullable = false,referencedColumnName = "contractId")
    @JsonBackReference
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachServiceId",nullable = false,referencedColumnName = "attachServiceId")
    @JsonBackReference
    private AttachService attachService;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
