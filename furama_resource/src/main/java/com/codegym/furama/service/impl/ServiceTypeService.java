package com.codegym.furama.service.impl;

import com.codegym.furama.entity.ServiceType;
import com.codegym.furama.repository.ServiceTypeRepository;
import com.codegym.furama.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
