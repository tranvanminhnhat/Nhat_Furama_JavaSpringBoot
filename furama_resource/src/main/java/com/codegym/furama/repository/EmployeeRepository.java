package com.codegym.furama.repository;

import com.codegym.furama.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {
    Page<Employee> findAllByEmployeeNameContainingAndEmployeeIdContaining(String name, String id, Pageable pageable);
}

