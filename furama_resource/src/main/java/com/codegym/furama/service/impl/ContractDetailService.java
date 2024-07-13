package com.codegym.furama.service.impl;

import com.codegym.furama.entity.ContractDetail;
import com.codegym.furama.repository.ContractDetailRepository;
import com.codegym.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Optional<ContractDetail> findById(Integer id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        contractDetailRepository.deleteById(id);
    }
}
