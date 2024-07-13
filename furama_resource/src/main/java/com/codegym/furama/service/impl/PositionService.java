package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Position;
import com.codegym.furama.repository.PositionRepository;
import com.codegym.furama.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return positionRepository.findAll();
    }
}
