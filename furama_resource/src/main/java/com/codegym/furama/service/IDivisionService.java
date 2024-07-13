package com.codegym.furama.service;

import com.codegym.furama.entity.Division;
import org.springframework.stereotype.Service;

@Service
public interface IDivisionService {
    Iterable<Division> findAll();
}
