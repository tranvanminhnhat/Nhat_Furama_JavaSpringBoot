package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Division;
import com.codegym.furama.repository.DivisionRepository;
import com.codegym.furama.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public Iterable<Division> findAll() {
        return divisionRepository.findAll();
    }
}
