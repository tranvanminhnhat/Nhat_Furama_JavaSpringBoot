package com.codegym.furama.service;

import com.codegym.furama.entity.Position;
import org.springframework.stereotype.Service;

@Service
public interface IPositionService {
    Iterable<Position> findAll();
}
