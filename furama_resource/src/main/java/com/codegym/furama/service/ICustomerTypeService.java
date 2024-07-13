package com.codegym.furama.service;

import com.codegym.furama.entity.CustomerType;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
}
