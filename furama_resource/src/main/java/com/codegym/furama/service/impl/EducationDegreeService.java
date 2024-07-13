package com.codegym.furama.service.impl;

import com.codegym.furama.entity.EducationDegree;
import com.codegym.furama.repository.EducationDegreeRepository;
import com.codegym.furama.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
