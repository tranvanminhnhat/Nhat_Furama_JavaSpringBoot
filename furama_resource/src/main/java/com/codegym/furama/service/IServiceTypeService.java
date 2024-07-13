package com.codegym.furama.service;

import com.codegym.furama.entity.ServiceType;

public interface IServiceTypeService {
    Iterable<ServiceType> findAll();
}
