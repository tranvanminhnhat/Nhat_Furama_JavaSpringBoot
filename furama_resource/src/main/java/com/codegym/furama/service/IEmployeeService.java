package com.codegym.furama.service;

import com.codegym.furama.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public interface IEmployeeService {

    void save(Employee employee);

    Page<Employee> findAll(Pageable pageable);

    Iterable<Employee> findAll();

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeIdContaining(String name, String id, Pageable pageable);

    Optional<Employee> findById(String id);

    void remove(String id);
}
