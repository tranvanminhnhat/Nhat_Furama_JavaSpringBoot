package com.codegym.furama.service;

import com.codegym.furama.entity.RentType;

public interface IRentTypeService {
    Iterable<RentType> findAll();
}
