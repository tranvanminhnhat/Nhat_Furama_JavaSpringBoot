package com.codegym.furama.service;

import com.codegym.furama.entity.Contract;
import com.codegym.furama.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IContractDetailService {

    void save(ContractDetail contractDetail);

    Page<ContractDetail> findAll(Pageable pageable);

    Optional<ContractDetail> findById(Integer id);

    void remove(Integer id);
}
