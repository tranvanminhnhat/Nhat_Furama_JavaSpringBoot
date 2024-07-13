package com.codegym.furama.service;

import com.codegym.furama.entity.EducationDegree;
import org.springframework.stereotype.Service;

@Service
public interface IEducationDegreeService {
    Iterable<EducationDegree> findAll();
}
