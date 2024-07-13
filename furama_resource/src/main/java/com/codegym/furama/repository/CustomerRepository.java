package com.codegym.furama.repository;

import com.codegym.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String name, String address, Pageable pageable);
}
