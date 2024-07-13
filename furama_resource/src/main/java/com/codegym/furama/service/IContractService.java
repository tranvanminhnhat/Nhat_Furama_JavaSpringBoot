package com.codegym.furama.service;

import com.codegym.furama.entity.Contract;
import com.codegym.furama.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IContractService {

    void save(Contract contract);
    
    Iterable<Contract> findAll();

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findAllByContractTotalMoney(Double contractTotalMoney, Pageable pageable);

    Optional<Contract> findById(Integer id);

    void remove(Integer id);
}
