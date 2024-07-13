package com.codegym.furama.service.impl;

import com.codegym.furama.entity.CustomerType;
import com.codegym.furama.repository.CustomerRepository;
import com.codegym.furama.repository.CustomerTypeRepository;
import com.codegym.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
