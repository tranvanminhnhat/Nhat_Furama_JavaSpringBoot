package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Contract;
import com.codegym.furama.repository.ContractRepository;
import com.codegym.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllByContractTotalMoney(Double contractTotalMoney, Pageable pageable) {
        return contractRepository.findAllByContractTotalMoney(contractTotalMoney, pageable);
    }

    @Override
    public Optional<Contract> findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        contractRepository.deleteById(id);
    }
}
