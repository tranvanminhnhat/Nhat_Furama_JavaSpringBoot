package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.repository.CustomerRepository;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String name, String address, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContainingAndCustomerAddressContaining(name, address, pageable);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }
}
