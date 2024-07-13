package com.codegym.furama.service;

import com.codegym.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICustomerService {
    void save(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    Iterable<Customer> findAll();

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String name, String address, Pageable pageable);

    Optional<Customer> findById(String id);

    void remove(String id);
}
