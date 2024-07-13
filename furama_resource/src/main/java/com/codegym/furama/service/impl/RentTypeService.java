package com.codegym.furama.service.impl;

import com.codegym.furama.entity.RentType;
import com.codegym.furama.repository.RentTypeRepository;
import com.codegym.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
