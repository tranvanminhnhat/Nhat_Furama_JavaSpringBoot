package com.codegym.furama.service.impl;

import com.codegym.furama.entity.*;
import com.codegym.furama.repository.EmployeeRepository;
import com.codegym.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContainingAndEmployeeIdContaining(String name, String id, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContainingAndEmployeeIdContaining(name, id, pageable);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void remove(String id) {
        employeeRepository.deleteById(id);
    }
}
