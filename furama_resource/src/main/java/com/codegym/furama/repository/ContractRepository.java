package com.codegym.furama.repository;

import com.codegym.furama.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContractRepository extends PagingAndSortingRepository<Contract, Integer> {
    Page<Contract> findAllByContractTotalMoney(Double contractTotalMoney, Pageable pageable);
}
